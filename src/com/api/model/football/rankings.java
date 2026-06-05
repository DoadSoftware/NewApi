package com.api.model.football;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class rankings {
	@JsonProperty("competition")
	private competition competition;
	  
	@JsonProperty("tournamentCalendar")	
	private TournamentCalendar tournamentCalendar;
	
	@JsonProperty("matchData")
	private List<matchData> matchData;
	  
	@JsonProperty("team")	
	private List<teamData> team;

	public rankings() {
		super();
	}

	public competition getCompetition() {
		return competition;
	}

	public void setCompetition(competition competition) {
		this.competition = competition;
	}

	public TournamentCalendar getTournamentCalendar() {
		return tournamentCalendar;
	}

	public void setTournamentCalendar(TournamentCalendar tournamentCalendar) {
		this.tournamentCalendar = tournamentCalendar;
	}

	public List<matchData> getMatchData() {
		return matchData;
	}

	public void setMatchData(List<matchData> matchData) {
		this.matchData = matchData;
	}

	public List<teamData> getTeam() {
		return team;
	}

	public void setTeam(List<teamData> team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "rankings [competition=" + competition + ", tournamentCalendar=" + tournamentCalendar + ", matchData="
				+ matchData + ", team=" + team + "]";
	}

}
