package com.api.model.tennis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {
	
	@JsonProperty("SetId")
	private int SetId;
	
	@JsonProperty("GameID")
	private String GameID;
	
	@JsonProperty("ServerTeamID")
	private String ServerTeamID;
	
	@JsonProperty("ServerPlayerID")
	private String ServerPlayerID;
	
	@JsonProperty("ReceiverTeamID")
	private String ReceiverTeamID;
	
	@JsonProperty("ReceiverPlayerID")
	private String ReceiverPlayerID;
	
	@JsonProperty("ServerScore")
	private String ServerScore;
	
	@JsonProperty("ReceiverScore")
	private String ReceiverScore;
	
	@JsonProperty("WinnerTeamID")
	private String WinnerTeamID;

}