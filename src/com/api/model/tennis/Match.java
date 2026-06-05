package com.api.model.tennis;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {

	@JsonProperty("name")
	private String name;
	  
	@JsonProperty("eventName")
	private String eventName;
	  
	@JsonProperty("tossWinner")	
	private String tossWinner;
	  
	@JsonProperty("roundName")
	private String roundName;
	  
	@JsonProperty("maxSets")
	private int maxSets;
	  
	@JsonProperty("leftTeamID")
	private String leftTeamID;
	  
	@JsonProperty("rightTeamID")
	private String rightTeamID;
	  
	@JsonProperty("currentServingPlayerId")
	private String currentServingPlayerId;
	  
	@JsonProperty("currentServingTeamId")
	private String currentServingTeamId;
	  
	@JsonProperty("teams")
	private List<Teams> Teams;
  
  
public String getTossWinner() {
	return tossWinner;
}
public void setTossWinner(String tossWinner) {
	this.tossWinner = tossWinner;
}
public String getCurrentServingPlayerId() {
	return currentServingPlayerId;
}
public void setCurrentServingPlayerId(String currentServingPlayerId) {
	this.currentServingPlayerId = currentServingPlayerId;
}
public String getCurrentServingTeamId() {
	return currentServingTeamId;
}
public void setCurrentServingTeamId(String currentServingTeamId) {
	this.currentServingTeamId = currentServingTeamId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRoundName() {
	return roundName;
}
public void setRoundName(String roundName) {
	this.roundName = roundName;
}
public String getEventName() {
	return eventName;
}
public void setEventName(String eventName) {
	this.eventName = eventName;
}

public String getLeftTeamID() {
	return leftTeamID;
}
public void setLeftTeamID(String leftTeamID) {
	this.leftTeamID = leftTeamID;
}

public String getRightTeamID() {
	return rightTeamID;
}
public void setRightTeamID(String rightTeamID) {
	this.rightTeamID = rightTeamID;
}

public int getMaxSets() {
	return maxSets;
}
public void setMaxSets(int maxSets) {
	this.maxSets = maxSets;
}

public List<Teams> getTeams() {
	return Teams;
}
public void setTeams(List<Teams> teams) {
	Teams = teams;
}
@Override
public String toString() {
	return "Match [name=" + name + ", eventName=" + eventName + ", tossWinner=" + tossWinner + ", roundName="
			+ roundName + ", maxSets=" + maxSets + ", leftTeamID=" + leftTeamID + ", rightTeamID=" + rightTeamID
			+ ", currentServingPlayerId=" + currentServingPlayerId + ", currentServingTeamId=" + currentServingTeamId
			+ ", Teams=" + Teams + "]";
}

}