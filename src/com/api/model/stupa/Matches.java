package com.api.model.stupa;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Matches {
	
	@JsonProperty("umpire_id")
	private int umpire_id;
	
	@JsonProperty("winner_name")
	private String winner_name;
	
	@JsonProperty("umpire_name")
	private String umpire_name;
	
	@JsonProperty("extra")
	private Extra extra;
	
	@JsonProperty("winner")
	private int winner;
	
	@JsonProperty("is_combo")
	private String is_combo;
	
	@JsonProperty("result")
	private String result;
	
	@JsonProperty("max_rally")
	private int max_rally;
	
	@JsonProperty("tie_id")
	private int tie_id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("point_json")
	private Point_json point_json;
	
	@JsonProperty("match_id")
	private int match_id;
	
	@JsonProperty("category_name")
	private String category_name;
	
	@JsonProperty("datetime")
	private String datetime;
	
	@JsonProperty("match_number")
	private int match_number;
	
	@JsonProperty("table")
	private int table;
	
	@JsonProperty("day")
	private int day;
	
	@JsonProperty("match_participants")
	private List<MatchParticipant> match_participants;
	
	@JsonProperty("score_stats")
	private Score score_stats;

	public int getUmpire_id() {
		return umpire_id;
	}

	public void setUmpire_id(int umpire_id) {
		this.umpire_id = umpire_id;
	}

	public String getWinner_name() {
		return winner_name;
	}

	public void setWinner_name(String winner_name) {
		this.winner_name = winner_name;
	}

	public String getUmpire_name() {
		return umpire_name;
	}

	public void setUmpire_name(String umpire_name) {
		this.umpire_name = umpire_name;
	}

	public Extra getExtra() {
		return extra;
	}

	public void setExtra(Extra extra) {
		this.extra = extra;
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

	public String getIs_combo() {
		return is_combo;
	}

	public void setIs_combo(String is_combo) {
		this.is_combo = is_combo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getMax_rally() {
		return max_rally;
	}

	public void setMax_rally(int max_rally) {
		this.max_rally = max_rally;
	}

	public int getTie_id() {
		return tie_id;
	}

	public void setTie_id(int tie_id) {
		this.tie_id = tie_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point_json getPoint_json() {
		return point_json;
	}

	public void setPoint_json(Point_json point_json) {
		this.point_json = point_json;
	}

	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getMatch_number() {
		return match_number;
	}

	public void setMatch_number(int match_number) {
		this.match_number = match_number;
	}

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public List<MatchParticipant> getMatch_participants() {
		return match_participants;
	}

	public void setMatch_participants(List<MatchParticipant> match_participants) {
		this.match_participants = match_participants;
	}

	public Score getScore_stats() {
		return score_stats;
	}

	public void setScore_stats(Score score_stats) {
		this.score_stats = score_stats;
	}

	@Override
	public String toString() {
		return "Matches [umpire_id=" + umpire_id + ", winner_name=" + winner_name + ", umpire_name=" + umpire_name
				+ ", extra=" + extra + ", winner=" + winner + ", is_combo=" + is_combo + ", result=" + result
				+ ", max_rally=" + max_rally + ", tie_id=" + tie_id + ", name=" + name + ", point_json=" + point_json
				+ ", match_id=" + match_id + ", category_name=" + category_name + ", datetime=" + datetime
				+ ", match_number=" + match_number + ", table=" + table + ", day=" + day + ", match_participants="
				+ match_participants + ", score_stats=" + score_stats + "]";
	}
	  
}