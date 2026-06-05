package com.api.model.football;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentMatchLineup {
	
	@JsonProperty("matchInfo")
	private MatchInfo matchInfo;
	
	@JsonProperty("provisionalLineUps")
	private ProvisionalLineups provisionalLineUps;

	public CurrentMatchLineup() {
		super();
	}

	public MatchInfo getMatchInfo() {
		return matchInfo;
	}

	public void setMatchInfo(MatchInfo matchInfo) {
		this.matchInfo = matchInfo;
	}

	public ProvisionalLineups getProvisionalLineUps() {
		return provisionalLineUps;
	}

	public void setProvisionalLineUps(ProvisionalLineups provisionalLineUps) {
		this.provisionalLineUps = provisionalLineUps;
	}

	@Override
	public String toString() {
		return "CurrentMatchLineup [matchInfo=" + matchInfo + ", provisionalLineUps=" + provisionalLineUps + "]";
	}
}