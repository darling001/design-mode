package com.gupao.vip.mybatis.v1;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/21
 * Time: 9:34
 * Description:
 */
public interface Executor {

    <T> T selectOne(String statement, Object parameter);


}
