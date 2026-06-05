package com.api.model.football;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PossesionEvent {
	
	@JsonProperty("matchInfo")
	private MatchInfo matchInfo;	
	
	@JsonProperty("liveData")
	private PossesionLiveData liveData;

	public PossesionEvent() {
		super();
	}

	public MatchInfo getMatchInfo() {
		return matchInfo;
	}

	public void setMatchInfo(MatchInfo matchInfo) {
		this.matchInfo = matchInfo;
	}

	public PossesionLiveData getLiveData() {
		return liveData;
	}

	public void setLiveData(PossesionLiveData liveData) {
		this.liveData = liveData;
	}

	@Override
	public String toString() {
		return "PossesionEvent [matchInfo=" + matchInfo + ", liveData=" + liveData + "]";
	}
	
}