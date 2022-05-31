package com.testeItauDev.StarWarsItau.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.testeItauDev.StarWarsItau.dto.StarWarsApiResponse;
import com.testeItauDev.StarWarsItau.service.PeopleService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PeopleController.class)
public class PeopleControllerTest {

	@Autowired
	private PeopleService peopleService;
	
	@GetMapping("test/{name}")
	public StarWarsApiResponse findPeopleByNameTest(@PathVariable String name) {
		
		return peopleService.findPeopleByName(name);
	}
		 		
		 
}