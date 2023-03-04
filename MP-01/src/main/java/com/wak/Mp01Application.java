package com.wak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wak.mapper")
public class Mp01Application {

    public static void main(String[] args) {
        SpringApplication.run(Mp01Application.class, args);
    }

}
