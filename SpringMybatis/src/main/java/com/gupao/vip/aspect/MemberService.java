package com.gupao.vip.aspect;

import com.gupao.vip.mapper.PeopleMapper;
import com.gupao.vip.param.PeopleParam;
import com.gupao.vip.pojo.People;
import com.gupao.vip.service.PeopleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Service
public class MemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    public boolean add(){
        logger.info("新增方法!");
        return true;
    }

    public void remove(){
        logger.info("删除方法!");
    }

}
