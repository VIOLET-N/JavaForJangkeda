package com.neusoft.springbootsell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ProductUser {
    @Id
    private Integer productUserId;
    //商家名称
    private String productUserName;
    //商家密码
    private String productUserPwd;
    //商家密码
    private String productUserPhone;
}
