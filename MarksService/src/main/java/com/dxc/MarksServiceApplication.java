package com.dxc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class MarksServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarksServiceApplication.class, args);
	}

}
