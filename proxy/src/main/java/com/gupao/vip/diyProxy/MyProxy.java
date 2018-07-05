package com.gupao.vip.diyProxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/3
 * Time: 11:12
 * Description:
 */
public class MyProxy {

    private static Map<Integer, String> classMap = new HashMap<>();

    private static String ln = "\r\n";

    private static String publicClassStr = "$Proxy";

    public static Object newInstance(MyClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler h) {
        try {
            String src = getText(interfaces);
            String filePath = MyProxy.class.getResource("").getPath();
            File file = new File(filePath + classMap.get(classMap.size() - 1) + ".java");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(src);
            fileWriter.flush();
            fileWriter.close();

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            Class proxyClass = classLoader.findClass(classMap.get(classMap.size() - 1));
            file.delete();
            Constructor constructor = proxyClass.getConstructor(MyInvocationHandler.class);
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getText(Class<?>[] interfaces) {
        int size = classMap.size();
        String classStr = null;
        if (size == 0) {
            classStr = "$Proxy0";
        } else {
            classStr = publicClassStr + size;
        }
        classMap.put(size, classStr);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package com.gupao.vip.diyProxy;" + ln);
        stringBuffer.append("import java.lang.reflect.Method;" + ln);
        stringBuffer.append("import com.gupao.vip.diyProxy.MyInvocationHandler;" + ln);
        stringBuffer.append("import com.gupao.vip.diyProxy.Father;" + ln);
        stringBuffer.append("import com.gupao.vip.diyProxy.People;" + ln);
        stringBuffer.append("import com.gupao.vip.diyProxy.Mother;" + ln);
        stringBuffer.append(ln);
        stringBuffer.append("public class " + classStr + " implements ");
        for (int i = 0; i < interfaces.length; i++) {
            if (i + 1 == interfaces.length) {
                stringBuffer.append(interfaces[i].getName() + "{" + ln);
            } else {
                stringBuffer.append(interfaces[i].getName() + ",");
            }
        }
        stringBuffer.append("MyInvocationHandler h;" + ln);
        stringBuffer.append(ln);
        stringBuffer.append("public " + classStr + "(MyInvocationHandler h){" + ln);
        stringBuffer.append("this.h = h;" + ln);
        stringBuffer.append("}" + ln);
        stringBuffer.append(ln);
        for (Class<?> clazz : interfaces) {
            for (Method method : clazz.getDeclaredMethods()) {
                Class<?>[] getTypeParameters = method.getParameterTypes();
                Parameter[] parameters = method.getParameters();
                if (getTypeParameters.length == 0) {
                    stringBuffer.append("public " + method.getReturnType().getName() + " " + method.getName() + "(){" + ln);
                } else {
                    stringBuffer.append("public " + method.getReturnType().getName() + " " + method.getName() + "(");
                    for (int i = 0; i < parameters.length; i++) {
                        if (i + 1 == parameters.length) {
                            stringBuffer.append(parameters[i].getType().getName() + " " + parameters[i].getName());
                        } else {
                            stringBuffer.append(parameters[i].getType().getName() + " " + parameters[i].getName() + ",");
                        }
                    }
                    stringBuffer.append("){" + ln);
                }
                stringBuffer.append("try{" + ln);
                stringBuffer.append("Method method = " + clazz.getName() + ".class.getDeclaredMethod(\"" + method.getName() + "\",new Class[]{");

                for (int i = 0; i < parameters.length; i++) {
                    if (i + 1 == parameters.length) {
                        stringBuffer.append(parameters[i].getType().getName() + ".class");
                    } else {
                        stringBuffer.append(parameters[i].getType().getName() + ".class,");
                    }
                }
                stringBuffer.append("});" + ln);
                if ("java.lang.String".equals(method.getReturnType().getName())) {
                    stringBuffer.append("return (String)this.h.invoke(this,method,");
                } else if ("int".equals(method.getReturnType().getName())) {
                    stringBuffer.append("return (Integer)this.h.invoke(this,method,");
                } else {
                    stringBuffer.append("this.h.invoke(this,method,");
                }
                if (getTypeParameters.length == 0) {
                    stringBuffer.append("null);" + ln);
                } else {
                    stringBuffer.append("new Object[]{");
                    for (int i = 0; i < parameters.length; i++) {
                        if (i + 1 == parameters.length) {
                            stringBuffer.append(parameters[i].getName());
                        } else {
                            stringBuffer.append(parameters[i].getName() + ",");
                        }
                    }
                    stringBuffer.append("});" + ln);
                }
                stringBuffer.append("} catch (Throwable e) {" + ln);
                stringBuffer.append("e.printStackTrace();" + ln);
                stringBuffer.append("}" + ln);
                if ("java.lang.String".equals(method.getReturnType().getName())) {
                    stringBuffer.append("return null;" + ln);
                } else if ("int".equals(method.getReturnType().getName())) {
                    stringBuffer.append("return 0;" + ln);
                } else {

                }
                stringBuffer.append("}" + ln);
                stringBuffer.append(ln);
            }
        }
        stringBuffer.append("}" + ln);
        return stringBuffer.toString();
    }

}
