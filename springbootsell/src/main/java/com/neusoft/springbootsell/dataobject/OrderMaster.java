package com.neusoft.springbootsell.dataobject;


import com.neusoft.springbootsell.enums.OrderStatusEnum;
import com.neusoft.springbootsell.enums.PayStatusEnum;
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
    private String buyerName;
    //买家地址
    private String buyerPhone;
    //买家微信 openId
    private String buyerAddress;
    //订单id
    private String buyerOpenid;
    //订单总金额
    private BigDecimal orderAmount;
    //订单 状态
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    //支付状态
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    //创建时间
    private Date createTime;

    private Date updateTime;
}
