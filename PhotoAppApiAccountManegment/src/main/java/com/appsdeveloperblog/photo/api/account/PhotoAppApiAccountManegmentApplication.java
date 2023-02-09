package com.appsdeveloperblog.photo.api.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppApiAccountManegmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoAppApiAccountManegmentApplication.class, args);
    }

}
