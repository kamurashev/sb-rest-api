package org.zapto.trywithfun.sbrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SbRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbRestApiApplication.class, args);
    }
}
