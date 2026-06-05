package com.api.model.stupa;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
	
	@JsonProperty("matchInfo")
	private MatchInfo matchInfo;
	
	@JsonProperty("scoreInfo")
	private ScoreInfo scoreInfo;
	
	@JsonProperty("competitor")
	private List<Competitor> competitor;

	public MatchInfo getMatchInfo() {
		return matchInfo;
	}

	public void setMatchInfo(MatchInfo matchInfo) {
		this.matchInfo = matchInfo;
	}

	public ScoreInfo getScoreInfo() {
		return scoreInfo;
	}

	public void setScoreInfo(ScoreInfo scoreInfo) {
		this.scoreInfo = scoreInfo;
	}

	public List<Competitor> getCompetitor() {
		return competitor;
	}

	public void setCompetitor(List<Competitor> competitor) {
		this.competitor = competitor;
	}

	@Override
	public String toString() {
		return "Info [matchInfo=" + matchInfo + ", scoreInfo=" + scoreInfo + ", competitor=" + competitor + "]";
	}
	
}