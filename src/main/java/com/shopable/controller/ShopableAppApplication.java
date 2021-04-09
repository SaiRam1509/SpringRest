package com.shopable.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.shopable.controller","com.shopable.service","com.shopable.DAO"})
@SpringBootApplication
public class ShopableAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopableAppApplication.class, args);
	}

}
