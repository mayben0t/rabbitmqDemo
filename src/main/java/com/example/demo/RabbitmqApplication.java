package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqApplication {

	public static void main(String[] args)
	{
//		System.out.println(new RabbitmqApplication().host);
		SpringApplication.run(RabbitmqApplication.class, args);
	}

//	@Value("${spring.profiles.active}")
//	private String host;

}
