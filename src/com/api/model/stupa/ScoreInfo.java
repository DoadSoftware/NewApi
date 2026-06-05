package com.api.model.stupa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScoreInfo {
	
	@JsonProperty("gameScores")
	private String gameScores;
	
	@JsonProperty("matchScore")
	private String matchScore;
	
	@JsonProperty("currentGame")
	private int currentGame;

	public String getGameScores() {
		return gameScores;
	}

	public void setGameScores(String gameScores) {
		this.gameScores = gameScores;
	}

	public String getMatchScore() {
		return matchScore;
	}

	public void setMatchScore(String matchScore) {
		this.matchScore = matchScore;
	}

	public int getCurrentGame() {
		return currentGame;
	}

	public void setCurrentGame(int currentGame) {
		this.currentGame = currentGame;
	}

	@Override
	public String toString() {
		return "ScoreInfo [gameScores=" + gameScores + ", matchScore=" + matchScore + ", currentGame=" + currentGame
				+ "]";
	}
	  
}