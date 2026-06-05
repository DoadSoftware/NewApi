package com.api.model.stupa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("playerId")
	private int playerId;
	
	@JsonProperty("playerMatchPos")
	private int playerMatchPos;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getPlayerMatchPos() {
		return playerMatchPos;
	}

	public void setPlayerMatchPos(int playerMatchPos) {
		this.playerMatchPos = playerMatchPos;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", gender=" + gender + ", playerId=" + playerId + ", playerMatchPos="
				+ playerMatchPos + "]";
	}

}