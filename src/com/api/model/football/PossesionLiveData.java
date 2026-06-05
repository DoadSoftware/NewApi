package com.api.model.football;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PossesionLiveData {

	@JsonProperty("matchDetails")
	private MatchDetails matchDetails;
	 
	@JsonProperty("event")
	private List<Events> event;

	public PossesionLiveData() {
		super();
	}

	public MatchDetails getMatchDetails() {
		return matchDetails;
	}

	public void setMatchDetails(MatchDetails matchDetails) {
		this.matchDetails = matchDetails;
	}

	public List<Events> getEvent() {
		return event;
	}

	public void setEvent(List<Events> event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "PossesionLiveData [matchDetails=" + matchDetails + ", event=" + event + "]";
	}
	
}