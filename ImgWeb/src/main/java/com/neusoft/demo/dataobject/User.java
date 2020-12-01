package com.neusoft.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@DynamicUpdate
public class User {
    @Id
    private Integer userId;
    //名称
    private String userName;
    //密码
    private String userPassword;
    //手机
    private String userPhone;
}
