package com.gupao.vip.mapper;

import com.gupao.vip.pojo.InsertSpeed;

import java.util.List;

public interface InsertSpeedMapper {

    int insert(InsertSpeed record);

    int insertSelective(InsertSpeed record);

    int insertList(List<InsertSpeed> list);
}