package com.gupao.vip.myProxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/2
 * Time: 17:27
 * Description:
 */
//生成代理对象的代码
public class GPProxy {

    private static String ln = "\r\n";

    public static Object newProxyInstance(GPClassLoader classLoader, Class<?>[] interfaces, GPInvocationHandler h) {
        try {
            //1.生成源代码
            String proxySrc = generateSrc(interfaces[0]);
            //2.将生成的源代码输出到磁盘，保存为.java文件
            String filePath = GPProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(proxySrc);
            fw.flush();
            fw.close();
            //3.编译源代码，并且生成,class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            //4.将class文件中的内容，动态加载到JVM中来
            //5.返回被代理后的代理对象
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor constructor = proxyClass.getConstructor(GPInvocationHandler.class);
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?> interfaces) throws IllegalAccessException, InstantiationException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package com.gupao.vip.myProxy;" + ln);
        stringBuffer.append("import java.lang.reflect.Method;" + ln);
        stringBuffer.append("import com.gupao.vip.Person;" + ln);
        stringBuffer.append(ln);
        stringBuffer.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);
        stringBuffer.append(ln);
        stringBuffer.append("GPInvocationHandler h;" + ln);
        stringBuffer.append(ln);
        stringBuffer.append("public $Proxy0(GPInvocationHandler var1){" + ln);
        stringBuffer.append("this.h = var1;" + ln);
        stringBuffer.append("}" + ln);
        stringBuffer.append(ln);
        for (Method method : interfaces.getDeclaredMethods()) {
            stringBuffer.append("public " + method.getReturnType().getName() + " " + method.getName() + "() {" + ln);
            stringBuffer.append("try{" + ln);
            stringBuffer.append("Method method = " + interfaces.getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{});" + ln);
            if ("void".equals(method.getReturnType().getName()))  {
                stringBuffer.append("this.h.invoke(this,method,null);" + ln);
            } else {
                stringBuffer.append("return (String)this.h.invoke(this,method,null);" + ln);
            }
            stringBuffer.append("} catch (Throwable e) {" + ln);
            stringBuffer.append("e.printStackTrace();" + ln);
            stringBuffer.append("}" + ln);
            if (!"void".equals(method.getReturnType().getName())) {
                stringBuffer.append("return null;" + ln);
            } else {

            }
            stringBuffer.append("}" + ln);
            stringBuffer.append(ln);
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }


}
