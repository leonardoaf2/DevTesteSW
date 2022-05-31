package com.desafiostarwars.testestarwars.controller;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiostarwars.testestarwars.model.People;
import com.desafiostarwars.testestarwars.service.PeopleService;

@RestController
@RequestMapping("/personagem")
public class PeopleController {

	@Autowired
	private PeopleService peopleService;

	@GetMapping("/{id}")
	public ResponseEntity<People> getById(@PathVariable @NotBlank @NumberFormat Integer id){
		
		People people = peopleService.getById(id);
		return new ResponseEntity<>(people,HttpStatus.OK);
	}
	
}
