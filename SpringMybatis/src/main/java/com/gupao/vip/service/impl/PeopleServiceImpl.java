package com.gupao.vip.service.impl;

import com.gupao.vip.mapper.PeopleMapper;
import com.gupao.vip.param.PeopleParam;
import com.gupao.vip.pojo.People;
import com.gupao.vip.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/29
 * Time: 17:11
 * Description:
 */
@Service("poepleService")
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    PeopleMapper peopleMapper;

    public People selectPeopleByParam(PeopleParam peopleParam){
        return peopleMapper.selectPeople(peopleParam);
    }
}
