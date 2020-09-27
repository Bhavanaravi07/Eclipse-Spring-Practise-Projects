package com.dxc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.dxc")
@SpringBootApplication
public class Demo02WebMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo02WebMvcApplication.class, args);
	}

}
