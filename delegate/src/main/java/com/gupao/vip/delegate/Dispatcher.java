package com.gupao.vip.delegate;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/4
 * Time: 15:34
 * Description:
 */
public class Dispatcher implements IExecutor {

    IExecutor executor;

    public Dispatcher(IExecutor executor) {
        this.executor = executor;
    }

    //项目经理，虽然也有执行方法
    //但是他的工作职责是不一样的
    //分配任务
    public void doing() {
        this.executor.doing();
    }

}
