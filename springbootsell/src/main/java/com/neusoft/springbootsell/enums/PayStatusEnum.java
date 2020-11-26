package com.neusoft.springbootsell.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum implements CodeEnums{
    WAIT(0,"等待支付")

    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
