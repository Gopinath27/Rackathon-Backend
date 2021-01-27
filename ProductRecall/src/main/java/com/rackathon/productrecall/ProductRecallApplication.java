package com.rackathon.productrecall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = {"com.rackathon"} )
public class ProductRecallApplication {

	public static void main(String[] args) {
		System.out.println("From JAVA OPTS URL :: "+System.getProperty("url"));
		SpringApplication.run(ProductRecallApplication.class, args);
		}

@RestController
class Login{
	@GetMapping("/")
	public String log() {
		return "<H1>Welcome to ProductRecall REST API</H1>";
	}
}
}
