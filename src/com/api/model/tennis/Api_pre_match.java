package com.api.model.tennis;

import java.util.List;

public class Api_pre_match {

	List<TeamPlayerStats> teamPlayerStats;

	public Api_pre_match(List<TeamPlayerStats> teamPlayerStats) {
		super();
		this.teamPlayerStats = teamPlayerStats;
	}

	public List<TeamPlayerStats> getTeamPlayerStats() {
		return teamPlayerStats;
	}

	public void setTeamPlayerStats(List<TeamPlayerStats> teamPlayerStats) {
		this.teamPlayerStats = teamPlayerStats;
	}
	
}