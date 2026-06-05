package com.api.model.football;

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

	public Game() {
		super();
	}

	public int getSetId() {
		return SetId;
	}

	public void setSetId(int setId) {
		SetId = setId;
	}

	public String getGameID() {
		return GameID;
	}

	public void setGameID(String gameID) {
		GameID = gameID;
	}

	public String getServerTeamID() {
		return ServerTeamID;
	}

	public void setServerTeamID(String serverTeamID) {
		ServerTeamID = serverTeamID;
	}

	public String getServerPlayerID() {
		return ServerPlayerID;
	}

	public void setServerPlayerID(String serverPlayerID) {
		ServerPlayerID = serverPlayerID;
	}

	public String getReceiverTeamID() {
		return ReceiverTeamID;
	}

	public void setReceiverTeamID(String receiverTeamID) {
		ReceiverTeamID = receiverTeamID;
	}

	public String getReceiverPlayerID() {
		return ReceiverPlayerID;
	}

	public void setReceiverPlayerID(String receiverPlayerID) {
		ReceiverPlayerID = receiverPlayerID;
	}

	public String getServerScore() {
		return ServerScore;
	}

	public void setServerScore(String serverScore) {
		ServerScore = serverScore;
	}

	public String getReceiverScore() {
		return ReceiverScore;
	}

	public void setReceiverScore(String receiverScore) {
		ReceiverScore = receiverScore;
	}

	public String getWinnerTeamID() {
		return WinnerTeamID;
	}

	public void setWinnerTeamID(String winnerTeamID) {
		WinnerTeamID = winnerTeamID;
	}

	@Override
	public String toString() {
		return "Game [SetId=" + SetId + ", GameID=" + GameID + ", ServerTeamID=" + ServerTeamID + ", ServerPlayerID="
				+ ServerPlayerID + ", ReceiverTeamID=" + ReceiverTeamID + ", ReceiverPlayerID=" + ReceiverPlayerID
				+ ", ServerScore=" + ServerScore + ", ReceiverScore=" + ReceiverScore + ", WinnerTeamID=" + WinnerTeamID
				+ "]";
	}

}