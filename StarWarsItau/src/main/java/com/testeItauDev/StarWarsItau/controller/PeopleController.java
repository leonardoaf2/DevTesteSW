package com.testeItauDev.StarWarsItau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testeItauDev.StarWarsItau.dto.StarWarsApiResponse;
import com.testeItauDev.StarWarsItau.service.PeopleService;


@RestController
@RequestMapping("/api/personagens")
public class PeopleController {

	@Autowired
	private PeopleService peopleService;
	
	//Pegando todos os personagens
	@GetMapping
	public StarWarsApiResponse findAll() {
		
		return peopleService.findAll();
	}
	
	//Pegando os personagens por nome
	@GetMapping("name/{name}")
	public StarWarsApiResponse findPeopleByName(@PathVariable String name) {
		
		return peopleService.findPeopleByName(name);
	}
}