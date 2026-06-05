package com.api.model.stupa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Score {
	
	@JsonProperty("tieId")
	private int tieId;
	
	@JsonProperty("competition")
	private Competition competition;

	public int getTieId() {
		return tieId;
	}

	public void setTieId(int tieId) {
		this.tieId = tieId;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	@Override
	public String toString() {
		return "Score [tieId=" + tieId + ", competition=" + competition + "]";
	}	
	  
}