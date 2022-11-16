package com.example.mydashboard;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
@EnableAdminServer
public class MyDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyDashboardApplication.class, args);
    }

}
