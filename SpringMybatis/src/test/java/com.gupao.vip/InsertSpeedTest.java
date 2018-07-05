package com.gupao.vip;


import com.gupao.vip.mapper.InsertSpeedMapper;
import com.gupao.vip.pojo.InsertSpeed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/15
 * Time: 10:05
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/app*.xml"})
public class InsertSpeedTest {

    @Autowired
    InsertSpeedMapper insertSpeedMapper;

    /**
     * for循环单挑插入
     */
    @Test
    public void insertOne(){
        Long startTime = System.currentTimeMillis();
        InsertSpeed insertSpeed = new InsertSpeed();
        for(int i=0;i<1000;i++){
            String name = "沈佳庆";
            Long createDate = System.currentTimeMillis();
            String createBy = "沈佳庆";
            Integer age = 26;
            String sex = "男";
            String job = "程序员";
            Integer grade = 5;
            String high = "179";
            Double weight = 168.0;
            insertSpeed.setAge(age);
            insertSpeed.setCreateBy(createBy);
            insertSpeed.setCreateDate(new Date(createDate));
            insertSpeed.setGrade(grade);
            insertSpeed.setHigh(high);
            insertSpeed.setJob(job);
            insertSpeed.setName(name);
            insertSpeed.setSex(sex);
            insertSpeed.setWeight(weight);
            insertSpeedMapper.insert(insertSpeed);
        }
        Long endTime = System.currentTimeMillis();
        //4205
        System.out.println(endTime-startTime);
    }

    /**
     * for循环批量插入
     */
    @Test
    public void insertList(){
        Long startTime = System.currentTimeMillis();
        InsertSpeed insertSpeed;
        List<InsertSpeed> list = new ArrayList<>();
        for(int i=1;i<=1000;i++){
            insertSpeed = new InsertSpeed();
            String name = "沈佳庆";
            Long createDate = System.currentTimeMillis();
            String createBy = "沈佳庆";
            Integer age = 26;
            String sex = "男";
            String job = "程序员";
            Integer grade = 5;
            String high = "179";
            Double weight = 168.0;
            insertSpeed.setAge(age);
            insertSpeed.setCreateBy(createBy);
            insertSpeed.setCreateDate(new Date(createDate));
            insertSpeed.setGrade(grade);
            insertSpeed.setHigh(high);
            insertSpeed.setJob(job);
            insertSpeed.setName(name);
            insertSpeed.setSex(sex);
            insertSpeed.setWeight(weight);
            list.add(insertSpeed);
            if(i%500==0) {
                insertSpeedMapper.insertList(list);
            }
        }
        Long endTime = System.currentTimeMillis();
        //1149
        System.out.println(endTime-startTime);
    }

    @Test
    public void insertBatch(){
        Long startTime = System.currentTimeMillis();
        InsertSpeed insertSpeed;
        List<InsertSpeed> list = new ArrayList<>();
        for(int i=1;i<=1000;i++){
            insertSpeed = new InsertSpeed();
            String name = "沈佳庆";
            Long createDate = System.currentTimeMillis();
            String createBy = "沈佳庆";
            Integer age = 26;
            String sex = "男";
            String job = "程序员";
            Integer grade = 5;
            String high = "179";
            Double weight = 168.0;
            insertSpeed.setAge(age);
            insertSpeed.setCreateBy(createBy);
            insertSpeed.setCreateDate(new Date(createDate));
            insertSpeed.setGrade(grade);
            insertSpeed.setHigh(high);
            insertSpeed.setJob(job);
            insertSpeed.setName(name);
            insertSpeed.setSex(sex);
            insertSpeed.setWeight(weight);
            list.add(insertSpeed);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);


    }


}
