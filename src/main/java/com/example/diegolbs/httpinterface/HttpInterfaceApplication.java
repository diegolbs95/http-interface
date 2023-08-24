package com.example.diegolbs.httpinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HttpInterfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpInterfaceApplication.class, args);
	}

}
