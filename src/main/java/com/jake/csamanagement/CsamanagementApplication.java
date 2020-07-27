package com.jake.csamanagement;

import com.github.pagehelper.PageHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@SpringBootApplication
@EnableTransactionManagement
public class CsamanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsamanagementApplication.class, args);
    }



}
