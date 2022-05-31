package com.desafiostarwars.testestarwars.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.desafiostarwars.testestarwars.model.Specie;
import com.desafiostarwars.testestarwars.model.People;

@Service
public class PeopleService {

	@Autowired
	private StarWarsApiService starWarsApiSerivce;
	
	
	@Cacheable("getPeopleById")
	public People getById(Integer id) {
		People people = starWarsApiSerivce.getPeople(id);
		
		setSimilars(people);
		
		return people;
	}

	//estabelecer similaridades
	private void setSimilars(People people) {
		people.setSimiliarIds(new ArrayList<>());
		
		for (Integer specieId : people.getSpecieIds()) {
			Specie specie = starWarsApiSerivce.getSpecie(specieId);
			
			people.getSimiliarIds().addAll(specie.getPeopleIds());
			people.getSimiliarIds().remove(people.getId());
			
			if(people.getSimiliarIds().size() > 2) {
				//criando sublista para deixar só os 3 valores nescessarios
				people.setSimiliarIds(new ArrayList<>(people.getSimiliarIds().subList(0, 3)) );
				break;
			}
		}
	}

}
