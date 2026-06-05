package com.api.model.tennis;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Teams {
	
	@JsonProperty("SetsWon")
	private int SetsWon;
	
	@JsonProperty("TeamID")
	private String TeamID;
	
	@JsonProperty("TeamName")
	private String TeamName;
	
	@JsonProperty("TeamPoints")
	private int TeamPoints;
	
	@JsonProperty("Players")
	private List<Player> Player;

}