package com.gupao.vip;


import com.gupao.vip.mapper.PeopleMapper;
import com.gupao.vip.mybatis.v2.executor.SimpleExecutor;
import com.gupao.vip.mybatis.v2.session.Configuration;
import com.gupao.vip.mybatis.v2.session.SqlSession;
import com.gupao.vip.param.PeopleParam;
import com.gupao.vip.pojo.People;
import com.gupao.vip.service.PeopleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/21
 * Time: 10:23
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/app*.xml"})
public class PeopleTest {

    @Autowired
    PeopleMapper peopleMapper;

    @Autowired
    PeopleService peopleService;

    @Test
    public void selectPeopleById(){
        SqlSession sqlSession = new SqlSession(new SimpleExecutor(),new Configuration());
        PeopleMapper peopleMapper = sqlSession.getMapper(PeopleMapper.class,sqlSession);
        Integer id = 1;
        People people = peopleMapper.selectPeopleById(id);
        System.out.println(people);
    }

    @Test
    public void selectPeopleByIdV2(){
        SqlSession sqlSession = new SqlSession(new SimpleExecutor(),new Configuration());
        PeopleMapper peopleMapper = sqlSession.getMapper(PeopleMapper.class,sqlSession);
        People people = peopleMapper.selectPeopleById(1);
        System.out.println(people);
    }


    @Test
    public void selectPeople(){
        People people = peopleMapper.selectPeopleById(1);
        System.out.println(people);
        People people1 = peopleMapper.selectPeopleById(1);
        System.out.println(people);


        People people2 = new People();
        people2.getJob();
        people2.getAge();
    }
    //org.apache.ibatis.binding.MapperProxy@4acf72b6

    @Test
    public void hahaha(){
        People people = peopleMapper.selectPeopleById(1);
        System.out.println(people);
    }

    @Test
    public void verifySet(){
        Set<String> set = new HashSet<>();
        Map<Integer,Set<String>> map = new HashMap<>();
        set.add("1");
        map.put(1,set);
        set.add("2");
        map.put(1,set);
        set.add("3");
        map.put(2,set);
        System.out.println(map);
    }

    @Test
    public void verifyAop(){
        PeopleParam peopleParam = new PeopleParam();
        peopleParam.setAge(26);
        peopleParam.setId(1);
        peopleParam.setJob("java程序员");
//        peopleParam.setName();
//        peopleParam.setSex();
        peopleService.selectPeopleByParam(peopleParam);
    }
}
