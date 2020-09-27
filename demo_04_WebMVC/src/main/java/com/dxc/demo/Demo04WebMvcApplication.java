package com.dxc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.dxc")
@SpringBootApplication
public class Demo04WebMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo04WebMvcApplication.class, args);
	}

}
