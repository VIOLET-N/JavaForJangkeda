package com.neusoft.demo.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Type {
    @Id
    private Integer typeId;
    //类型名称
    private String typeName;
}
