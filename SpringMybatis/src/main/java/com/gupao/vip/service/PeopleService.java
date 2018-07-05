package com.gupao.vip.service;

import com.gupao.vip.param.PeopleParam;
import com.gupao.vip.pojo.People;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/29
 * Time: 17:10
 * Description:
 */
public interface PeopleService {

    People selectPeopleByParam(PeopleParam peopleParam);
}
