package com.api.model.stupa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Action {
	
	@JsonProperty("setA")
	private int setA;
	
	@JsonProperty("setH")
	private int setH;
	
	@JsonProperty("scoreA")
	private int scoreA;
	
	@JsonProperty("scoreH")
	private int scoreH;
	
	@JsonProperty("isWinner")
	private int isWinner;
	
	@JsonProperty("leftSide")
	private String leftSide;
	
	@JsonProperty("rightSide")
	private String rightSide;
	
	@JsonProperty("WinnerTeamId")
	private int WinnerTeamId;
	
	@JsonProperty("serverPlayer")
	private int serverPlayer;
	
	@JsonProperty("serverTeamId")
	private int serverTeamId;
	
	@JsonProperty("goldenpointCount")
	private int goldenpointCount;
	
	@JsonProperty("serverCompetitor")
	private int serverCompetitor;

	public int getSetA() {
		return setA;
	}

	public void setSetA(int setA) {
		this.setA = setA;
	}

	public int getSetH() {
		return setH;
	}

	public void setSetH(int setH) {
		this.setH = setH;
	}

	public int getScoreA() {
		return scoreA;
	}

	public void setScoreA(int scoreA) {
		this.scoreA = scoreA;
	}

	public int getScoreH() {
		return scoreH;
	}

	public void setScoreH(int scoreH) {
		this.scoreH = scoreH;
	}

	public int getIsWinner() {
		return isWinner;
	}

	public void setIsWinner(int isWinner) {
		this.isWinner = isWinner;
	}

	public String getLeftSide() {
		return leftSide;
	}

	public void setLeftSide(String leftSide) {
		this.leftSide = leftSide;
	}

	public String getRightSide() {
		return rightSide;
	}

	public void setRightSide(String rightSide) {
		this.rightSide = rightSide;
	}

	public int getWinnerTeamId() {
		return WinnerTeamId;
	}

	public void setWinnerTeamId(int winnerTeamId) {
		WinnerTeamId = winnerTeamId;
	}

	public int getServerPlayer() {
		return serverPlayer;
	}

	public void setServerPlayer(int serverPlayer) {
		this.serverPlayer = serverPlayer;
	}

	public int getServerTeamId() {
		return serverTeamId;
	}

	public void setServerTeamId(int serverTeamId) {
		this.serverTeamId = serverTeamId;
	}

	public int getGoldenpointCount() {
		return goldenpointCount;
	}

	public void setGoldenpointCount(int goldenpointCount) {
		this.goldenpointCount = goldenpointCount;
	}

	public int getServerCompetitor() {
		return serverCompetitor;
	}

	public void setServerCompetitor(int serverCompetitor) {
		this.serverCompetitor = serverCompetitor;
	}

	@Override
	public String toString() {
		return "Action [setA=" + setA + ", setH=" + setH + ", scoreA=" + scoreA + ", scoreH=" + scoreH + ", isWinner="
				+ isWinner + ", leftSide=" + leftSide + ", rightSide=" + rightSide + ", WinnerTeamId=" + WinnerTeamId
				+ ", serverPlayer=" + serverPlayer + ", serverTeamId=" + serverTeamId + ", goldenpointCount="
				+ goldenpointCount + ", serverCompetitor=" + serverCompetitor + "]";
	}
	
}