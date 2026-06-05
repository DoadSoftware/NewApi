package com.api.model.football;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonalStats {

	@JsonProperty("competition")
	private competition Competition;
	
	@JsonProperty("tournamentCalendar")
	private TournamentCalendar tournamentCalendar;
	
	@JsonProperty("contestant")
	private Contestant contestant;
	
	@JsonProperty("player")
	private List<SeasonalPlayerStats> player;

	public SeasonalStats() {
		super();
	}

	public competition getCompetition() {
		return Competition;
	}

	public void setCompetition(competition competition) {
		Competition = competition;
	}

	public TournamentCalendar getTournamentCalendar() {
		return tournamentCalendar;
	}

	public void setTournamentCalendar(TournamentCalendar tournamentCalendar) {
		this.tournamentCalendar = tournamentCalendar;
	}

	public Contestant getContestant() {
		return contestant;
	}

	public void setContestant(Contestant contestant) {
		this.contestant = contestant;
	}

	public List<SeasonalPlayerStats> getPlayer() {
		return player;
	}

	public void setPlayer(List<SeasonalPlayerStats> player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "SeasonalStats [Competition=" + Competition + ", tournamentCalendar=" + tournamentCalendar
				+ ", contestant=" + contestant + "]";
	}

}