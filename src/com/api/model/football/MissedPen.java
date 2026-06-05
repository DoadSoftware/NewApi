package com.api.model.football;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class MissedPen {
	
	@JsonProperty("contestantId")
	private String contestantId;
	
	@JsonProperty("periodId")
	private String periodId;

	@JsonProperty("timeMin")
	private String timeMin;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("playerId")
	private String playerId;
	
	@JsonProperty("decision")
	private String decision;
	
	@JsonProperty("probability")
	private String probability;
	
	@JsonProperty("outcome")
	private String outcome;
	
	@JsonProperty("playerName")
	private String playerName;
	
	@JsonProperty("optaEventId")
	private String optaEventId;
}
