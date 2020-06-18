package com.simpleSpringBootECommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class SimpleSpringBootECommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSpringBootECommerceApplication.class, args);
    }

}
