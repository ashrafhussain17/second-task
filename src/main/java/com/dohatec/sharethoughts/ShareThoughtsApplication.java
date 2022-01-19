package com.dohatec.sharethoughts;

import com.dohatec.sharethoughts.model.Post;
import com.dohatec.sharethoughts.model.Tags;
import com.dohatec.sharethoughts.model.User;
import com.dohatec.sharethoughts.repository.PostRepository;
import com.dohatec.sharethoughts.repository.TagsRepository;
import com.dohatec.sharethoughts.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

import java.util.UUID;

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
