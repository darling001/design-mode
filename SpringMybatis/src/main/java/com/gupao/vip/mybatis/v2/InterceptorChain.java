package com.gupao.vip.mybatis.v2;



import com.gupao.vip.plugin.MyPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/26
 * Time: 10:03
 * Description:
 */
public class InterceptorChain {

    private final static List<Interceptor> interceptors = new ArrayList<>();

    static {
        interceptors.add(new MyPlugin());
    }

    public Object pluginAll(Object target) {
        for(Interceptor interceptor : interceptors){
            target = interceptor.plugin(target);
        }
        return target;
    }
}
