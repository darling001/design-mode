package com.gupao.vip.frameJDBC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/8/3
 * Time: 16:32
 * Description:
 */
public class QueryRule implements Serializable{

    private static final long serialVersionUID = 1L;
    public static final int ASC_ORDER = 101;
    public static final int DESC_ORDER = 102;
    public static final int LIKE = 1;
    public static final int IN = 2;
    public static final int NOTIN = 3;
    public static final int BETWEEN = 4;
    public static final int EQ = 5;
    public static final int NOTEQ = 6;
    public static final int GT = 7;
    public static final int GE = 8;
    public static final int LT = 9;
    public static final int LE = 10;
    public static final int ISNULL = 11;
    public static final int ISNOTNULL = 12;
    public static final int ISEMPTY = 13;
    public static final int ISNOTEMPTY = 14;
    public static final int AND = 201;
    public static final int OR = 202;
    private List<Rule> ruleList = new ArrayList<Rule>();
    private List<QueryRule> queryRuleList = new ArrayList<QueryRule>();
    private String propertyName;

    public QueryRule addEqual(String propertyName, Object ... values){
        this.ruleList.add(new Rule(EQ,propertyName,new Object[]{values}).setAndOr(AND));
        return this;
    }

    protected class Rule implements Serializable{

        private int type;

        private String propertyName;

        private Object[] values;

        private int andOr;

        public Rule(int type,String propertyName,Object[] values){
            this.type = type;
            this.propertyName = propertyName;
            this.values = values;
        }

        public Rule setAndOr(int andOr){
            this.andOr = andOr;
            return this;
        }


    }

}
