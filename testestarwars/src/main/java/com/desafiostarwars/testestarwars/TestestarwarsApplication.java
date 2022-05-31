package com.desafiostarwars.testestarwars;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class TestestarwarsApplication {

	private static Logger logger = LoggerFactory.getLogger(TestestarwarsApplication.class);
	
	public static void main(String[] args) {
		
		logger.info("Starting the SWAPI api with recommendation.");
		SpringApplication.run(TestestarwarsApplication.class, args);
		logger.info("SWAPI api with recommendation started and ready to receive requests.");
	}

}
