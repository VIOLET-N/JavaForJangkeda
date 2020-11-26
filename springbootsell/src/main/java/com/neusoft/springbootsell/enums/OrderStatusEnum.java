package com.neusoft.springbootsell.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum implements CodeEnums {
    NEW(0,"新订单")
    ;

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
