package com.neusoft.springbootsell.dataobject;

import com.neusoft.springbootsell.enums.ProductStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;
    //商品名字
    private String productName;
    //单价
    private BigDecimal productPrice;
    //库存
    private Integer productStock;
    //描述
    private String productDescription;
    //小图
    private String productIcon;
    //状态
    private Integer productStatus = ProductStatusEnum.UP.getCode();
    //类目编号
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
