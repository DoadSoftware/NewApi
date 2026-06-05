package com.api.model.tennis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Player
{
	@JsonProperty("PlayerID")
	private int playerId;
	
	@JsonProperty("TeamID")
	private int playerTeamID;
	
	@JsonProperty("PlayerName")  
	private String playerName;

}