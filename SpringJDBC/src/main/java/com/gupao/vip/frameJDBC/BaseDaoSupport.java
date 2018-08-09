package com.gupao.vip.frameJDBC;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/8/3
 * Time: 16:31
 * Description:
 */
public abstract class BaseDaoSupport<T extends Serializable,PK extends Serializable> {

    private String tableName = "";
}
