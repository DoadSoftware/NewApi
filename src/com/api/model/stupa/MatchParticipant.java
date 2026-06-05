package com.api.model.stupa;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchParticipant {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("points_won")
	private int points_won;
	
	@JsonProperty("games_won")
	private int games_won;
	
	@JsonProperty("games")
	private List<Integer> games;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("forehand_win_rate")
	private String forehand_win_rate;
	
	@JsonProperty("serve_conversion_rate")
	private String serve_conversion_rate;
	
	@JsonProperty("match_id")
	private int match_id;
	
//	@JsonProperty("user_id")
//	private int user_id;
	
	@JsonProperty("points_lost")
	private int points_lost;
	
	@JsonProperty("games_lost")
	private int games_lost;
	
	@JsonProperty("points")
	private List<Integer> points;
	
	@JsonProperty("backhand_win_rate")
	private int backhand_win_rate;
	
	@JsonProperty("user")
	private User user;
	
	@JsonProperty("participant_id")
	private int participant_id;

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

	public int getGames_won() {
		return games_won;
	}

	public void setGames_won(int games_won) {
		this.games_won = games_won;
	}

	public List<Integer> getGames() {
		return games;
	}

	public void setGames(List<Integer> games) {
		this.games = games;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getForehand_win_rate() {
		return forehand_win_rate;
	}

	public void setForehand_win_rate(String forehand_win_rate) {
		this.forehand_win_rate = forehand_win_rate;
	}

	public String getServe_conversion_rate() {
		return serve_conversion_rate;
	}

	public void setServe_conversion_rate(String serve_conversion_rate) {
		this.serve_conversion_rate = serve_conversion_rate;
	}

	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

//	public int getUser_id() {
//		return user_id;
//	}
//
//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}

	public int getPoints_lost() {
		return points_lost;
	}

	public void setPoints_lost(int points_lost) {
		this.points_lost = points_lost;
	}

	public int getGames_lost() {
		return games_lost;
	}

	public void setGames_lost(int games_lost) {
		this.games_lost = games_lost;
	}

	public List<Integer> getPoints() {
		return points;
	}

	public void setPoints(List<Integer> points) {
		this.points = points;
	}

	public int getBackhand_win_rate() {
		return backhand_win_rate;
	}

	public void setBackhand_win_rate(int backhand_win_rate) {
		this.backhand_win_rate = backhand_win_rate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getParticipant_id() {
		return participant_id;
	}

	public void setParticipant_id(int participant_id) {
		this.participant_id = participant_id;
	}

	@Override
	public String toString() {
		return "MatchParticipant [id=" + id + ", points_won=" + points_won + ", games_won=" + games_won + ", games="
				+ games + ", name=" + name + ", forehand_win_rate=" + forehand_win_rate + ", serve_conversion_rate="
				+ serve_conversion_rate + ", match_id=" + match_id + ", points_lost=" + points_lost + ", games_lost="
				+ games_lost + ", points=" + points + ", backhand_win_rate=" + backhand_win_rate + ", user=" + user
				+ ", participant_id=" + participant_id + "]";
	}

}