package com.api.model.khelo_india;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KheloIndia {
	
	@JsonProperty("state_id")
	private String state_id;
	
	@JsonProperty("state_name")
	private String state_name;
	
	@JsonProperty("gold")
	private int gold;

	@JsonProperty("silver")
	private int silver;

	@JsonProperty("bronze")
	private int bronze;

	@JsonProperty("total")
	private int total;

	@JsonProperty("rank")
	private int rank;

	public String getState_id() {
		return state_id;
	}

	public void setState_id(String state_id) {
		this.state_id = state_id;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getSilver() {
		return silver;
	}

	public void setSilver(int silver) {
		this.silver = silver;
	}

	public int getBronze() {
		return bronze;
	}

	public void setBronze(int bronze) {
		this.bronze = bronze;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public KheloIndia(String state_id, String state_name, int gold, int silver, int bronze, int total, int rank) {
		super();
		this.state_id = state_id;
		this.state_name = state_name;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
		this.total = total;
		this.rank = rank;
	}

	public KheloIndia() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "KheloIndia [state_id=" + state_id + ", state_name=" + state_name + ", gold=" + gold + ", silver="
				+ silver + ", bronze=" + bronze + ", total=" + total + ", rank=" + rank + "]";
	}
	
}