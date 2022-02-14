package com.example.simplecrud_member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SimpleCrudMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleCrudMemberApplication.class, args);
    }

}
