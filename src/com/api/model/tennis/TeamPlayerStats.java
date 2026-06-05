package com.api.model.tennis;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamPlayerStats {
	
	@JsonProperty("SetsWon")
	private int SetsWon;
	
	@JsonProperty("TeamID")
	private String TeamID;
	
	@JsonProperty("TeamName")
	private String TeamName;
	
	@JsonProperty("TeamPoints")
	private int TeamPoints;
	
}