package com.neusoft.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

//用户发送图片类
@Entity
@Data
@DynamicUpdate
public class User_Send_Img {
    @Id
    private Integer id;

    private Integer userId;

    private Integer imgId;
}
