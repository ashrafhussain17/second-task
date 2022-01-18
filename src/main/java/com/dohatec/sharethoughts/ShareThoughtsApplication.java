package com.dohatec.sharethoughts;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

@SpringBootApplication
public class ShareThoughtsApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ShareThoughtsApplication.class);
        logger.info("starting the application, hi from the main class");
        logger.trace("this log is for trace");
        logger.warn("this log is for warning");
        SpringApplication.run(ShareThoughtsApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
