package com.br.cateno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@ServletComponentScan
@EnableCaching
public class CatenoApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CatenoApplication.class, args);
    }

}
