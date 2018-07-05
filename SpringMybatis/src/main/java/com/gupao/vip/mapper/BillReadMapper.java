package com.gupao.vip.mapper;


import com.gupao.vip.pojo.BillRead;

import java.util.List;

public interface BillReadMapper{

    List<BillRead> selectByBillRead(BillRead bl);

    int insert(BillRead record);

    int insertSelective(BillRead record);

}