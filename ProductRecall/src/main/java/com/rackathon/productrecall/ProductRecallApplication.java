package com.rackathon.productrecall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = {"com.rackathon"} )
public class ProductRecallApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductRecallApplication.class, args);
	}

@RestController
class Login{
	@GetMapping("/")
	public String log() {
		return "Welcome to ProductRecall REST API";
	}
}
}
