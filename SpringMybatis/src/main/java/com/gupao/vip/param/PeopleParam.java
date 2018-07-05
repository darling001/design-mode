package com.gupao.vip.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/29
 * Time: 17:00
 * Description:
 */
@Data
public class PeopleParam implements Serializable{

    @NotEmpty(message = "id不能为空" )
    private int id;

    @NotBlank(message = "姓名不能为空")
    private String name;

    private int age;

    @NotBlank(message = "性别不能为空")
    private String sex;

    private String job;




}
