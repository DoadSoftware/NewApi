package com.api.model.stupa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Point_json {
	
	@JsonProperty("tieId")
	private int tieId;
	
	@JsonProperty("tieNumber")
	private int tieNumber;
	
	@JsonProperty("competition")
	private Competition competition;
	
	@JsonProperty("matchNumber")
	private int matchNumber;
	
	@JsonProperty("competitionCode")
	private String competitionCode;

	public int getTieId() {
		return tieId;
	}

	public void setTieId(int tieId) {
		this.tieId = tieId;
	}

	public int getTieNumber() {
		return tieNumber;
	}

	public void setTieNumber(int tieNumber) {
		this.tieNumber = tieNumber;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public int getMatchNumber() {
		return matchNumber;
	}

	public void setMatchNumber(int matchNumber) {
		this.matchNumber = matchNumber;
	}

	public String getCompetitionCode() {
		return competitionCode;
	}

	public void setCompetitionCode(String competitionCode) {
		this.competitionCode = competitionCode;
	}

	@Override
	public String toString() {
		return "Point_json [tieId=" + tieId + ", tieNumber=" + tieNumber + ", competition=" + competition
				+ ", matchNumber=" + matchNumber + ", competitionCode=" + competitionCode + "]";
	}
	
}