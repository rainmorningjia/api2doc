package com.alibaba.api2doc;

import com.terran4j.commons.api2doc.config.EnableApi2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApi2Doc
public class Api2docApplication {

    public static void main(String[] args) {
        SpringApplication.run(Api2docApplication.class, args);
    }

}
