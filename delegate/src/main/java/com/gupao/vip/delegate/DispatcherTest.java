package com.gupao.vip.delegate;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/4
 * Time: 15:36
 * Description:
 */
public class DispatcherTest {

    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(new TargetA());
        //看上去好像是我们的项目经理在干活
        //但实际干活的人是我们普通员工
        //这就是典型，干活是我的，功劳是你的
        dispatcher.doing();
    }
}
