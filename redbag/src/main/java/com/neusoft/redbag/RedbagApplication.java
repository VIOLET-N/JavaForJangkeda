package com.neusoft.redbag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication
public class RedbagApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedbagApplication.class, args);
    }

}
