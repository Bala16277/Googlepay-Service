package com.hcl.googlepay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GooglepayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GooglepayApplication.class, args);
	}

}
