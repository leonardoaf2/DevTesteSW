package com.desafiostarwars.testestarwars.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.desafiostarwars.testestarwars.exception.TechnicalException;
import com.desafiostarwars.testestarwars.model.People;
import com.desafiostarwars.testestarwars.model.Specie;

@Service
public class StarWarsApiService {
	
	private RestTemplate restTemplate;

	private static final String UrlRoot = "https://swapi.dev/api/";
	private static final String UrlGet =  UrlRoot + "%s/%s";
	private static final String UrlFind = UrlRoot + "%s/?search=%s";
	
	
	public StarWarsApiService() {
		this.restTemplate = new RestTemplate();
	}
	
	@Cacheable("getPeople")
	public People getPeople(Integer id) {
		return this.get("people", id, People.class);
	}
	
	@Cacheable("getSpecie")
	public Specie getSpecie(Integer id) {
		return this.get("species", id, Specie.class);
	}
	
	public List<People> findPeoples(String name) {
		return this.find("people", name, People[].class);
	}
	
	private <T> T get(String entityPath,Integer argument,Class<T> type) {
		
		ResponseEntity<T> response = restTemplate.getForEntity(getURI(UrlGet, entityPath,String.valueOf(argument)), type);
		
		if(!response.getStatusCode().equals(HttpStatus.OK))
			throw new RestClientException("error: " + response.getStatusCode());
		
		return response.getBody();
	}
	
	private <T> List<T> find(String entityPath,String argument,Class<T[]> clasz) {
		
		ResponseEntity<String> response = restTemplate.getForEntity(getURI(UrlFind,entityPath, argument), String.class);
		
		if(!response.getStatusCode().equals(HttpStatus.OK))
			throw new RestClientException("error: " + response.getStatusCode());
		
		T[] arrayObjectT = getArrayFromBody(clasz, response.getBody(),"results");
		
		if(arrayObjectT == null || arrayObjectT.length == 0)
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		
		return Arrays.asList(arrayObjectT);
	}

	private URI getURI(String url,String entityPath, String argument){
		try {
			return new URI(String.format(url, entityPath,argument));
		} catch(URISyntaxException e) {
			throw new TechnicalException(e.getCause());
		}
	}

	private <T> T[] getArrayFromBody(Class<T[]> clasz, String body,String arrayField){
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode = mapper.readTree(body).get(arrayField);
			return mapper.treeToValue(jsonNode, clasz);
		} catch (JsonProcessingException e) {
			throw new TechnicalException(e.getCause());
		} 
	}

}