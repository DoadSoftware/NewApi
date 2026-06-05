package com.api.model.stupa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchInfo {
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("eventName")
	private String eventName;
	
	@JsonProperty("yellowCard")
	private boolean yellowCard;
	
	@JsonProperty("yellowRed1")
	private boolean yellowRed1;
	
	@JsonProperty("yellowRed2")
	private boolean yellowRed2;
	
	@JsonProperty("bestOfXGames")
	private int bestOfXGames;
	
	@JsonProperty("advantagePerGame")
	private int advantagePerGame;
	
	@JsonProperty("maxPointsPerGame")
	private int maxPointsPerGame;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public boolean isYellowCard() {
		return yellowCard;
	}

	public void setYellowCard(boolean yellowCard) {
		this.yellowCard = yellowCard;
	}

	public boolean isYellowRed1() {
		return yellowRed1;
	}

	public void setYellowRed1(boolean yellowRed1) {
		this.yellowRed1 = yellowRed1;
	}

	public boolean isYellowRed2() {
		return yellowRed2;
	}

	public void setYellowRed2(boolean yellowRed2) {
		this.yellowRed2 = yellowRed2;
	}

	public int getBestOfXGames() {
		return bestOfXGames;
	}

	public void setBestOfXGames(int bestOfXGames) {
		this.bestOfXGames = bestOfXGames;
	}

	public int getAdvantagePerGame() {
		return advantagePerGame;
	}

	public void setAdvantagePerGame(int advantagePerGame) {
		this.advantagePerGame = advantagePerGame;
	}

	public int getMaxPointsPerGame() {
		return maxPointsPerGame;
	}

	public void setMaxPointsPerGame(int maxPointsPerGame) {
		this.maxPointsPerGame = maxPointsPerGame;
	}

	@Override
	public String toString() {
		return "MatchInfo [gender=" + gender + ", eventName=" + eventName + ", yellowCard=" + yellowCard
				+ ", yellowRed1=" + yellowRed1 + ", yellowRed2=" + yellowRed2 + ", bestOfXGames=" + bestOfXGames
				+ ", advantagePerGame=" + advantagePerGame + ", maxPointsPerGame=" + maxPointsPerGame + "]";
	}
	  
}