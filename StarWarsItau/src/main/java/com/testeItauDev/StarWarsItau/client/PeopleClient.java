package com.testeItauDev.StarWarsItau.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.testeItauDev.StarWarsItau.dto.StarWarsApiResponse;


@FeignClient(
		url = "${services.api-starwars.url}",
		name = "PeopleClient",
		contextId="PeopleClientId"
)
public interface PeopleClient {
	
	//Encontrar todos os personagens
	@GetMapping
	Optional<StarWarsApiResponse> findAll();
	
	//Encontrar o personagem que pedir para a aplicação
	@GetMapping()
	Optional<StarWarsApiResponse> findByPeopleName(@RequestParam(name = "search") String PeopleTitle);
}