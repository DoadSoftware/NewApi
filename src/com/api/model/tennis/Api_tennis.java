package com.api.model.tennis;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Api_tennis {
	@JsonProperty("Name")
	private String Name;
	
	@JsonProperty("EventName")
	private String EventName;
	
	@JsonProperty("Round")
	private String Round;
	
	@JsonProperty("MaxSets")
	private int MaxSets;
	
	@JsonProperty("Scorer")
	private String Scorer;
	
	@JsonProperty("TossWinner")
	private String TossWinner;
	
	@JsonProperty("LeftTeamID")
	private String LeftTeamID;
	
	@JsonProperty("RightTeamID")
	private String RightTeamID;
	
	@JsonProperty("CurrentServingTeamID")
	private String currentServingTeamID;
	
	@JsonProperty("CurrentServingPlayerID")
	private String CurrentServingPlayerID;
	
	@JsonProperty("Event")
	private String Event;
	
	@JsonProperty("Teams")
	private List<Teams> Teams;
	
	@JsonProperty("Sets")
	private List<Sets> Sets;
	
}