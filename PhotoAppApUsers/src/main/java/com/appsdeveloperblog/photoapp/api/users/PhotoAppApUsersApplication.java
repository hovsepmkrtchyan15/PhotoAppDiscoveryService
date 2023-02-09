package com.appsdeveloperblog.photoapp.api.users;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class PhotoAppApUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoAppApUsersApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    Logger.Level feignLoggerLover() {
        return Logger.Level.FULL;
    }

    @Bean
    @Profile("production")
    public String createProductionBean() {
        System.out.println("Production bean created");
        return "Production bean";
    }

    @Bean
    @Profile("!production")
    public String createNotProductionBean() {
        System.out.println("Not production bean created");
        return "Not Production bean";
    }

    @Bean
    @Profile("!production")
    public String createDevelopmentBean() {
        System.out.println("Development bean created");
        return "Development bean";
    }
//    @Bean
//    public FeignErrorDecoder getFeignErrorDecoder(){
//        return new FeignErrorDecoder();
//    }
}
