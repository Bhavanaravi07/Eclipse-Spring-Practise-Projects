package com.dxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.dxc")
@SpringBootApplication

public class Demo08SpringBootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo08SpringBootSecurityApplication.class, args);
	}

}
