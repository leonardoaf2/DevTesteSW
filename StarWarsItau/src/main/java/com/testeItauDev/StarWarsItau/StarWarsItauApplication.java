package com.testeItauDev.StarWarsItau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StarWarsItauApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarWarsItauApplication.class, args);
	}

}
