package com.communitynotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CommunitynotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunitynotesApplication.class, args);
    }   

}