package com.sjsu.javageeks.user;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = { "com.sjsu.javageeks.user.controller"})
@ComponentScan
public class UserApplication{
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(UserApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}	
		
}
