package com.api.model.stupa;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
	
	@JsonProperty("name")
	private String name;
	  
	@JsonProperty("logo")
	private String logo;
	
	@JsonProperty("team_id")
	private int team_id;
	  
	@JsonProperty("coach_info")
	private String coach_info;
	
	@JsonProperty("users")
	private List<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getCoach_info() {
		return coach_info;
	}

	public void setCoach_info(String coach_info) {
		this.coach_info = coach_info;
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", logo=" + logo + ", team_id=" + team_id + ", coach_info=" + coach_info
				+ ", users=" + users + "]";
	}

}