package com.api.model.stupa;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tie {

	@JsonProperty("datetime")
	private String datetime;
	  
	@JsonProperty("winner")
	private int winner;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("day")
	private int day;
	
	@JsonProperty("group_type")
	private String group_type;
	  
	@JsonProperty("tie_id")
	private int tie_id;
	
	@JsonProperty("result")
	private String result;
	
	@JsonProperty("tie_number")
	private int tie_number;
	
	@JsonProperty("winner_name")
	private String winner_name;
	
	@JsonProperty("matches")
	private List<Matches> matches;
	
	@JsonProperty("tie_participants")
	private List<Tie_Team> tie_participants;
	
	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getWinner() {
		return winner;
	}
	
	public void setWinner(int winner) {
		this.winner = winner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getGroup_type() {
		return group_type;
	}

	public void setGroup_type(String group_type) {
		this.group_type = group_type;
	}

	public int getTie_id() {
		return tie_id;
	}

	public void setTie_id(int tie_id) {
		this.tie_id = tie_id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getTie_number() {
		return tie_number;
	}

	public void setTie_number(int tie_number) {
		this.tie_number = tie_number;
	}

	public String getWinner_name() {
		return winner_name;
	}

	public void setWinner_name(String winner_name) {
		this.winner_name = winner_name;
	}

	public List<Matches> getMatches() {
		return matches;
	}

	public void setMatches(List<Matches> matches) {
		this.matches = matches;
	}

	public List<Tie_Team> getTie_participants() {
		return tie_participants;
	}

	public void setTie_participants(List<Tie_Team> tie_participants) {
		this.tie_participants = tie_participants;
	}

	@Override
	public String toString() {
		return "Tie [datetime=" + datetime + ", winner=" + winner + ", name=" + name + ", day=" + day + ", group_type="
				+ group_type + ", tie_id=" + tie_id + ", result=" + result + ", tie_number=" + tie_number
				+ ", winner_name=" + winner_name + ", matches=" + matches + ", tie_participants=" + tie_participants
				+ "]";
	}

}