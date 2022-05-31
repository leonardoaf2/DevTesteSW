package com.testeItauDev.StarWarsItau.dto;

import java.util.Collections;
import java.util.List;

import com.testeItauDev.StarWarsItau.model.People;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StarWarsApiResponse {
	
	//Listando os pesonagens que aparesem no resultado
	private List<People> results;
	
	public static StarWarsApiResponse createEmptyResult() {
		
		var response = new StarWarsApiResponse();
		response.setResults(Collections.emptyList());
		return response;
		
	}

	public List<People> getResults() {
		return results;
	}

	public void setResults(List<People> results) {
		this.results = results;
	}
	
	
}