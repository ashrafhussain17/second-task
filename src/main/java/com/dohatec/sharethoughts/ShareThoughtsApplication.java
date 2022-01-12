package com.dohatec.sharethoughts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShareThoughtsApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ShareThoughtsApplication.class);
        logger.info("starting the application, hi from the main class");
        SpringApplication.run(ShareThoughtsApplication.class, args);
    }
}
