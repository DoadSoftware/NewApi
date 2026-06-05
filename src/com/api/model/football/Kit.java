package com.api.model.football;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Kit {

	@JsonProperty("id")
	private String id;
	  
	@JsonProperty("colour1")
	private String colour1;
	
	@JsonProperty("type")
	private String type;

	public Kit() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColour1() {
		return colour1;
	}

	public void setColour1(String colour1) {
		this.colour1 = colour1;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Kit [id=" + id + ", colour1=" + colour1 + ", type=" + type + "]";
	}

}