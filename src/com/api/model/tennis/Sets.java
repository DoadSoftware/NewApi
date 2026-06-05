package com.api.model.tennis;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sets {
	
	@JsonProperty("WonTeamID")
	private int WonTeamID;
	
	@JsonProperty("ID")
	private int ID;
	
	@JsonProperty("TeamATieScore")
	private int TeamATieScore;
	
	@JsonProperty("TeamAScore")
	private int TeamAScore;
	
	@JsonProperty("TeamBTieScore")
	private int TeamBTieScore;
	
	@JsonProperty("TeamBScore")
	private int TeamBScore;
	
	@JsonProperty("TieBreaker")
	private boolean TieBreaker;
	
	@JsonProperty("Games")
	private List<Game> Game;

}