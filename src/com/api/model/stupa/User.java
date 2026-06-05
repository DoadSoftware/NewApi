package com.api.model.stupa;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("matches_won")
	private int matches_won;
	
	@JsonProperty("last_five_matches")
	private List<Integer> last_five_matches;
	
	@JsonProperty("achievements")
	private String achievements;
	
	@JsonProperty("role_id")
	private int role_id;
	
	@JsonProperty("matches_lost")
	private int matches_lost;
	
	@JsonProperty("max_set_streak")
	private int max_set_streak;
	
	@JsonProperty("nationality")
	private String nationality;
	
	@JsonProperty("golden_points_played")
	private int golden_points_played;
	
	@JsonProperty("current_set_streak")
	private int current_set_streak;
	
	@JsonProperty("golden_points_won")
	private int golden_points_won;
	
//	@JsonProperty("user_id")
//	private int user_id;
	
	@JsonProperty("first_point_win_rate")
	private int first_point_win_rate;
	
	@JsonProperty("points_won")
	private int points_won;
		
	@JsonProperty("forehand_win_rate")
	private int forehand_win_rate;
	
	@JsonProperty("team_id")
	private int team_id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("points_lost")
	private int points_lost;
	
	@JsonProperty("backhand_win_rate")
	private int backhand_win_rate;
	
	@JsonProperty("india_rank")
	private int india_rank;
	
	@JsonProperty("games_won")
	private int games_won;
	
	@JsonProperty("serve_conversion_rate")
	private int serve_conversion_rate;
	
	@JsonProperty("games_lost")
	private int games_lost;
	
	@JsonProperty("win_percentage")
	private double win_percentage;
	
	@JsonProperty("game_win_rate")
	private double game_win_rate;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMatches_won() {
		return matches_won;
	}

	public void setMatches_won(int matches_won) {
		this.matches_won = matches_won;
	}

	public List<Integer> getLast_five_matches() {
		return last_five_matches;
	}

	public void setLast_five_matches(List<Integer> last_five_matches) {
		this.last_five_matches = last_five_matches;
	}

	public String getAchievements() {
		return achievements;
	}

	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getMatches_lost() {
		return matches_lost;
	}

	public void setMatches_lost(int matches_lost) {
		this.matches_lost = matches_lost;
	}

	public int getMax_set_streak() {
		return max_set_streak;
	}

	public void setMax_set_streak(int max_set_streak) {
		this.max_set_streak = max_set_streak;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getGolden_points_played() {
		return golden_points_played;
	}

	public void setGolden_points_played(int golden_points_played) {
		this.golden_points_played = golden_points_played;
	}

	public int getCurrent_set_streak() {
		return current_set_streak;
	}

	public void setCurrent_set_streak(int current_set_streak) {
		this.current_set_streak = current_set_streak;
	}

	public int getGolden_points_won() {
		return golden_points_won;
	}

	public void setGolden_points_won(int golden_points_won) {
		this.golden_points_won = golden_points_won;
	}

	public int getFirst_point_win_rate() {
		return first_point_win_rate;
	}

	public void setFirst_point_win_rate(int first_point_win_rate) {
		this.first_point_win_rate = first_point_win_rate;
	}

	public int getPoints_won() {
		return points_won;
	}

	public void setPoints_won(int points_won) {
		this.points_won = points_won;
	}

	public int getForehand_win_rate() {
		return forehand_win_rate;
	}

	public void setForehand_win_rate(int forehand_win_rate) {
		this.forehand_win_rate = forehand_win_rate;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints_lost() {
		return points_lost;
	}

	public void setPoints_lost(int points_lost) {
		this.points_lost = points_lost;
	}

	public int getBackhand_win_rate() {
		return backhand_win_rate;
	}

	public void setBackhand_win_rate(int backhand_win_rate) {
		this.backhand_win_rate = backhand_win_rate;
	}

	public int getIndia_rank() {
		return india_rank;
	}

	public void setIndia_rank(int india_rank) {
		this.india_rank = india_rank;
	}

	public int getGames_won() {
		return games_won;
	}

	public void setGames_won(int games_won) {
		this.games_won = games_won;
	}

	public int getServe_conversion_rate() {
		return serve_conversion_rate;
	}

	public void setServe_conversion_rate(int serve_conversion_rate) {
		this.serve_conversion_rate = serve_conversion_rate;
	}

	public int getGames_lost() {
		return games_lost;
	}

	public void setGames_lost(int games_lost) {
		this.games_lost = games_lost;
	}

	public double getWin_percentage() {
		return win_percentage;
	}

	public void setWin_percentage(double win_percentage) {
		this.win_percentage = win_percentage;
	}

	public double getGame_win_rate() {
		return game_win_rate;
	}

	public void setGame_win_rate(double game_win_rate) {
		this.game_win_rate = game_win_rate;
	}

	@Override
	public String toString() {
		return "User [gender=" + gender + ", matches_won=" + matches_won + ", last_five_matches=" + last_five_matches
				+ ", achievements=" + achievements + ", role_id=" + role_id + ", matches_lost=" + matches_lost
				+ ", max_set_streak=" + max_set_streak + ", nationality=" + nationality + ", golden_points_played="
				+ golden_points_played + ", current_set_streak=" + current_set_streak + ", golden_points_won="
				+ golden_points_won + ", first_point_win_rate=" + first_point_win_rate + ", points_won=" + points_won
				+ ", forehand_win_rate=" + forehand_win_rate + ", team_id=" + team_id + ", name=" + name
				+ ", points_lost=" + points_lost + ", backhand_win_rate=" + backhand_win_rate + ", india_rank="
				+ india_rank + ", games_won=" + games_won + ", serve_conversion_rate=" + serve_conversion_rate
				+ ", games_lost=" + games_lost + ", win_percentage=" + win_percentage + ", game_win_rate="
				+ game_win_rate + "]";
	}
	
}