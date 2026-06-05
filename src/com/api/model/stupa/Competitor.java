package com.api.model.stupa;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Competitor {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("scores")
	private String scores;
	
	@JsonProperty("teamId")
	private int teamId;
	
	@JsonProperty("players")
	List<Player> players;
	
	@JsonProperty("biggestLead")
	private int biggestLead;
	
	@JsonProperty("competitorId")
	private String competitorId;
	
	@JsonProperty("organization")
	private String organization;
	
	@JsonProperty("average1point")
	private int average1point;
	
	@JsonProperty("participantId")
	private String participantId;
	
	@JsonProperty("competitorType")
	private String competitorType;
	
	@JsonProperty("totalGoldenPts")
	private int totalGoldenPts;
	
	@JsonProperty("golden_points_won")
	private int golden_points_won;
	
	@JsonProperty("totalGoldenPtsWon")
	private int totalGoldenPtsWon;
	
	@JsonProperty("current_set_streak")
	private int current_set_streak;
	
	@JsonProperty("first_point_win_rate")
	private int first_point_win_rate;
	
	@JsonProperty("golden_points_played")
	private int golden_points_played;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScores() {
		return scores;
	}

	public void setScores(String scores) {
		this.scores = scores;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getBiggestLead() {
		return biggestLead;
	}

	public void setBiggestLead(int biggestLead) {
		this.biggestLead = biggestLead;
	}

	public String getCompetitorId() {
		return competitorId;
	}

	public void setCompetitorId(String competitorId) {
		this.competitorId = competitorId;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public int getAverage1point() {
		return average1point;
	}

	public void setAverage1point(int average1point) {
		this.average1point = average1point;
	}

	public String getParticipantId() {
		return participantId;
	}

	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}

	public String getCompetitorType() {
		return competitorType;
	}

	public void setCompetitorType(String competitorType) {
		this.competitorType = competitorType;
	}

	public int getTotalGoldenPts() {
		return totalGoldenPts;
	}

	public void setTotalGoldenPts(int totalGoldenPts) {
		this.totalGoldenPts = totalGoldenPts;
	}

	public int getGolden_points_won() {
		return golden_points_won;
	}

	public void setGolden_points_won(int golden_points_won) {
		this.golden_points_won = golden_points_won;
	}

	public int getTotalGoldenPtsWon() {
		return totalGoldenPtsWon;
	}

	public void setTotalGoldenPtsWon(int totalGoldenPtsWon) {
		this.totalGoldenPtsWon = totalGoldenPtsWon;
	}

	public int getCurrent_set_streak() {
		return current_set_streak;
	}

	public void setCurrent_set_streak(int current_set_streak) {
		this.current_set_streak = current_set_streak;
	}

	public int getFirst_point_win_rate() {
		return first_point_win_rate;
	}

	public void setFirst_point_win_rate(int first_point_win_rate) {
		this.first_point_win_rate = first_point_win_rate;
	}

	public int getGolden_points_played() {
		return golden_points_played;
	}

	public void setGolden_points_played(int golden_points_played) {
		this.golden_points_played = golden_points_played;
	}

	@Override
	public String toString() {
		return "Competitor [name=" + name + ", scores=" + scores + ", teamId=" + teamId + ", players=" + players
				+ ", biggestLead=" + biggestLead + ", competitorId=" + competitorId + ", organization=" + organization
				+ ", average1point=" + average1point + ", participantId=" + participantId + ", competitorType="
				+ competitorType + ", totalGoldenPts=" + totalGoldenPts + ", golden_points_won=" + golden_points_won
				+ ", totalGoldenPtsWon=" + totalGoldenPtsWon + ", current_set_streak=" + current_set_streak
				+ ", first_point_win_rate=" + first_point_win_rate + ", golden_points_played=" + golden_points_played
				+ "]";
	}
	
}