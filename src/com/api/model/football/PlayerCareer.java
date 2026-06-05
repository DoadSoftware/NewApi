package com.api.model.football;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerCareer {

	@JsonProperty("person")
	private List<Person> person;
	
	public PlayerCareer() {
		super();
	}

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "PlayerCareer [person=" + person + "]";
	}
	
}