package com.cogent.Discounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DiscountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscountsApplication.class, args);
	}

}
