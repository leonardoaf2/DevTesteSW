package com.testeItauDev.StarWarsItau.model;

import java.util.List;

public class People {
	
	private Integer id;
	private String name;
	private String birthYear;
	private String eyeColor;
	private String gender;
	private String hairColor;
	private String height;
	private String mass;
	private String skinColor;
	private Integer homeworldId;
	private List<Integer> filmIds;
	private List<Integer> specieIds;
	private List<Integer> starshipIds;
	private List<Integer> vehicleIds;
	private List<Integer> similiarIds;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getMass() {
		return mass;
	}
	public void setMass(String mass) {
		this.mass = mass;
	}
	public String getSkinColor() {
		return skinColor;
	}
	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}
	public Integer getHomeworldId() {
		return homeworldId;
	}
	public void setHomeworldId(Integer homeworldId) {
		this.homeworldId = homeworldId;
	}
	public List<Integer> getFilmIds() {
		return filmIds;
	}
	public void setFilmIds(List<Integer> filmIds) {
		this.filmIds = filmIds;
	}
	public List<Integer> getSpecieIds() {
		return specieIds;
	}
	public void setSpecieIds(List<Integer> specieIds) {
		this.specieIds = specieIds;
	}
	public List<Integer> getStarshipIds() {
		return starshipIds;
	}
	public void setStarshipIds(List<Integer> starshipIds) {
		this.starshipIds = starshipIds;
	}
	public List<Integer> getVehicleIds() {
		return vehicleIds;
	}
	public void setVehicleIds(List<Integer> vehicleIds) {
		this.vehicleIds = vehicleIds;
	}
	public List<Integer> getSimiliarIds() {
		return similiarIds;
	}
	public void setSimiliarIds(List<Integer> similiarIds) {
		this.similiarIds = similiarIds;
	}
	
	
}
