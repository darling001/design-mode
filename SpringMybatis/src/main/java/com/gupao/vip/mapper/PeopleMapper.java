package com.gupao.vip.mapper;

import com.gupao.vip.param.PeopleParam;
import com.gupao.vip.pojo.People;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/7
 * Time: 17:14
 * Description:
 */
public interface PeopleMapper {
    @Select(value = "select * from people where id = ?")
 //   @Select(value = "select * from people where id = #{id}")
    People selectPeopleById(@Param("id") Integer id);

    People selectPeople(PeopleParam peopleParam);

}
