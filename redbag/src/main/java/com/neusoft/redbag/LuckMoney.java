package com.neusoft.redbag;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class LuckMoney {
    @Id
    @GeneratedValue
    private Integer id;

    private BigDecimal money;
    private String producer;
    private String consumer;


}
