package com.orange.basetool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BasetoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasetoolApplication.class, args);
    }

}
