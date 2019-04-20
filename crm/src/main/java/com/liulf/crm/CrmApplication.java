package com.liulf.crm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CrmApplication {

    private final static Logger logger = LoggerFactory.getLogger(CrmApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
        logger.info(CrmApplication.class.getSimpleName() + " is success!");

    }
}
