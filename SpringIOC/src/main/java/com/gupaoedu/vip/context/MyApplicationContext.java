package com.gupaoedu.vip.context;

import com.gupaoedu.vip.annotation.MyAutowired;
import com.gupaoedu.vip.annotation.MyController;
import com.gupaoedu.vip.annotation.MyService;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/8/9
 * Time: 11:31
 * Description:
 */
public class MyApplicationContext {

    private final List<String> cacheClass = new ArrayList<String>();

    private final Map<String,Object> instanceMapping = new ConcurrentHashMap<String,Object>();

    public MyApplicationContext(String location) {
        try {
            //1.定位
            InputStream is = this.getClass().getClassLoader().getResourceAsStream(location);
            //2.载入、解析
            Properties p = new Properties();
            p.load(is);
            String packageName = p.getProperty("packageName");
            //3.注册 扫描包下所有的类，将类保存到集合中
            doRegister(packageName);
            //将带有@MyController、@MyService的类初始化
            //4.初始化
            doCreateBean();
            //5.注入
            populate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册
     * @param packageName
     */
    private void doRegister(String packageName){
        URL url = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.","/"));
        File dir = new File(url.getFile());
        for(File file : dir.listFiles()){
            if(file.isDirectory()){
                doRegister(packageName + "." + file.getName());
            }else{
                cacheClass.add(packageName + "." + file.getName().replaceAll(".class","").trim());
            }
        }
    }

    /**
     * 初始化
     */
    private void doCreateBean(){
        if(cacheClass.size()==0){
            return;
        }
        try {
            for(String  className : cacheClass){
                Class<?> clazz = Class.forName(className);
                if(clazz.isAnnotationPresent(MyController.class)){
                    String idForController = clazz.getName();
                    instanceMapping.put(idForController,clazz.newInstance());
                }else if(clazz.isAnnotationPresent(MyService.class)){
                    MyService service = clazz.getAnnotation(MyService.class);
                    String id = service.value();
                    if(!"".equals(id.trim())){
                        instanceMapping.put(id,clazz.newInstance());
                        continue;
                    }
                    Class<?> [] interfaces = clazz.getInterfaces();
                    for(Class<?> i : interfaces){
                        String idForService = i.getName();
                        instanceMapping.put(idForService,clazz.newInstance());
                    }
                }else{
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将首字母小写
     * @param simpleName
     * @return
     */
    private String headerLower(String simpleName){
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    /**
     * 注入
     */
    private void populate() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        if(instanceMapping.size()==0){
            return;
        }
        for(Map.Entry<String,Object> entry : instanceMapping.entrySet()){
            Field [] fields = entry.getValue().getClass().getDeclaredFields();
            if(fields.length==0){
                continue;
            }
            for(Field field :fields){
                if(!field.isAnnotationPresent(MyAutowired.class)){
                    continue;
                }
                MyAutowired autowired = field.getAnnotation(MyAutowired.class);
                String id = autowired.value().trim();
                if("".equals(id)){
                    id = field.getType().getName();
                }
                field.setAccessible(true);
                Object a = instanceMapping.get(id);
                field.set(entry.getValue(),a);
            }
        }
    }


    public Map<String,Object> getAll(){
        return instanceMapping;
    }

    public Object getBean(String beanName){
        return instanceMapping.get(beanName);
    }


}
