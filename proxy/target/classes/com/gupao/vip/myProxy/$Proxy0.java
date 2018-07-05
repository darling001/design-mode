package com.gupao.vip.myProxy;
import java.lang.reflect.Method;
import com.gupao.vip.Person;

public class $Proxy0 implements com.gupao.vip.Person{

GPInvocationHandler h;

public $Proxy0(GPInvocationHandler var1){
this.h = var1;
}

public java.lang.String getName() {
try{
Method method = com.gupao.vip.Person.class.getMethod("getName",new Class[]{});
return (String)this.h.invoke(this,method,null);
} catch (Throwable e) {
e.printStackTrace();
}
return null;
}

public java.lang.String getSex() {
try{
Method method = com.gupao.vip.Person.class.getMethod("getSex",new Class[]{});
return (String)this.h.invoke(this,method,null);
} catch (Throwable e) {
e.printStackTrace();
}
return null;
}

public void findLove() {
try{
Method method = com.gupao.vip.Person.class.getMethod("findLove",new Class[]{});
this.h.invoke(this,method,null);
} catch (Throwable e) {
e.printStackTrace();
}
}

}