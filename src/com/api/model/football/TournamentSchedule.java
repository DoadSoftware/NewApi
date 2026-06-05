package com.api.model.football;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TournamentSchedule {
	
	@JsonProperty("competition")
	private competition competition;	
	
	@JsonProperty("tournamentCalendar")
	private TournamentCalendar TournamentCalendar;
	
	@JsonProperty("matchDate")
	private List<MatchDate> matchDate;

	public TournamentSchedule() {
		super();
	}

	public competition getCompetition() {
		return competition;
	}

	public void setCompetition(competition competition) {
		this.competition = competition;
	}

	public TournamentCalendar getTournamentCalendar() {
		return TournamentCalendar;
	}

	public void setTournamentCalendar(TournamentCalendar tournamentCalendar) {
		TournamentCalendar = tournamentCalendar;
	}

	public List<MatchDate> getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(List<MatchDate> matchDate) {
		this.matchDate = matchDate;
	}

	@Override
	public String toString() {
		return "TournamentSchedule [competition=" + competition + ", TournamentCalendar=" + TournamentCalendar
				+ ", matchDate=" + matchDate + "]";
	}
	
}