package com.lhf.mysqltransactionlock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.lhf.mysqltransactionlock.dao")
public class MysqlTransactionLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlTransactionLockApplication.class, args);
    }
}
