package com.neusoft.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class Img {
    @Id
    private Integer imgId;
    //图片存放地址
    private String imgAddress;
    //发图时间
    private Date createTime;
    //删除 0未删除 1删除
    private boolean isDelete;
}
