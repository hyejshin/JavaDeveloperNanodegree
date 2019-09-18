package com.example.eurekadogclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaDogclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDogclientApplication.class, args);
	}

}
