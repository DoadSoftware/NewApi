package com.api.model.tennis;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerStats {
	
	@JsonProperty("PlayerID")
	private int PlayerID;
	
	@JsonProperty("PlayerName")
	private String PlayerName;
	
	@JsonProperty("TeamName")
	private String TeamName;
	
	@JsonProperty("TeamID")
	private int TeamID;
	
	@JsonProperty("BreakAvailable")
	private int BreakAvailable;

	public int getPlayerID() {
		return PlayerID;
	}

	public void setPlayerID(int playerID) {
		PlayerID = playerID;
	}

	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}

	public String getTeamName() {
		return TeamName;
	}

	public void setTeamName(String teamName) {
		TeamName = teamName;
	}

	public int getTeamID() {
		return TeamID;
	}

	public void setTeamID(int teamID) {
		TeamID = teamID;
	}

	public int getBreakAvailable() {
		return BreakAvailable;
	}

	public void setBreakAvailable(int breakAvailable) {
		BreakAvailable = breakAvailable;
	}
	
	
}