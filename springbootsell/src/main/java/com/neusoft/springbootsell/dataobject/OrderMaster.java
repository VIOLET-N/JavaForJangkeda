package com.neusoft.springbootsell.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    //订单id
    @Id
    private String orderId;
    //买家名字
    private String userName;
    //买家地址
    private String buyerPhone;
    //买家微信 openId
    private String buyerAddress;
    //订单id
    private String buyerOpenId;
    //订单总金额
    private BigDecimal orderAmount;
    //订单 状态
    private Integer orderStatus = 0;
    //支付状态
    private Integer payStatus = 0;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
}
