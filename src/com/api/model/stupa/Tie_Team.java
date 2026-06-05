package com.api.model.stupa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tie_Team {
	
	@JsonProperty("id")
	private int id;
	  
	@JsonProperty("points_won")
	private int points_won;
	
	@JsonProperty("matches_won")
	private int matches_won;
	
	@JsonProperty("team_id")
	private int team_id;
	  
	@JsonProperty("tie_id")
	private int tie_id;
	
	@JsonProperty("games_won")
	private int games_won;

	@JsonProperty("team")
	private Team team;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoints_won() {
		return points_won;
	}

	public void setPoints_won(int points_won) {
		this.points_won = points_won;
	}

	public int getMatches_won() {
		return matches_won;
	}

	public void setMatches_won(int matches_won) {
		this.matches_won = matches_won;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public int getTie_id() {
		return tie_id;
	}

	public void setTie_id(int tie_id) {
		this.tie_id = tie_id;
	}

	public int getGames_won() {
		return games_won;
	}

	public void setGames_won(int games_won) {
		this.games_won = games_won;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", points_won=" + points_won + ", matches_won=" + matches_won + ", team_id="
				+ team_id + ", tie_id=" + tie_id + ", games_won=" + games_won + ", team=" + team + "]";
	}

}