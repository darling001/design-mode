package com.gupao.vip.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class BillRead extends BasePojo {


    private String billId;

    private String billType;

    private String companyId;

    private String companyName;

    private String accountId;

    private String accountName;

    private String operatorType;

    private String operatorUserId;

    private String operatorUserName;

    private Date operatorUserTime;

    String aaa;

    protected String bbb;



}