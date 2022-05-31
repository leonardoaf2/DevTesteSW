package com.testeItauDev.StarWarsItau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.testeItauDev.StarWarsItau.client.PeopleClient;
import com.testeItauDev.StarWarsItau.dto.StarWarsApiResponse;

@Service
public class PeopleService {

	@Autowired
	private PeopleClient peopleClient;
	
	public StarWarsApiResponse findAll() {
		try {
			return peopleClient
					.findAll()
					.orElse(StarWarsApiResponse.createEmptyResult());
		} catch (Exception ex) {
			ex.printStackTrace();
			return StarWarsApiResponse.createEmptyResult();
		}
	}
	
	public StarWarsApiResponse findPeopleByName(@PathVariable String name) {
		try {
			return peopleClient
					.findByPeopleName(name)
					.orElse(StarWarsApiResponse.createEmptyResult());
		} catch (Exception ex) {
			ex.printStackTrace();
			return StarWarsApiResponse.createEmptyResult();
		}
	}
}