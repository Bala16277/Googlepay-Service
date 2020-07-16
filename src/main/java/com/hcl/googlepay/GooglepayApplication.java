package com.hcl.googlepay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
<<<<<<< HEAD
=======
@EnableEurekaClient
@EnableFeignClients
>>>>>>> c66a04367499e1d2cb9d3592ee9c063e729c9c10
public class GooglepayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GooglepayApplication.class, args);
		
		System.out.println(" Welcome To Transaction Details ");
		
		
	}

}
