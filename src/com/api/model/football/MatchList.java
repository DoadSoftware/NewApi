package com.api.model.football;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class MatchList {
	@JsonProperty("match")
	private List<LiveMatch> match;

	public List<LiveMatch> getMatch() {
		return match;
	}

	public void setMatch(List<LiveMatch> match) {
		this.match = match;
	}

	@Override
	public String toString() {
		return "MatchList [match=" + match + "]";
	}

	public MatchList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatchList(List<LiveMatch> match) {
		super();
		this.match = match;
	}
	
}
