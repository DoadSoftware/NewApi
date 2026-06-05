package com.api.model.football;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Players")
public class PlayersTable implements Comparable<PlayersTable> {

  @Id
  @Column(name = "PLAYERID")
  private int playerId;
  
  @Column(name = "JERSEYNUMBER")
  private int jersey_number;
	
  @Column(name = "PLAYERAPIID")
  private String player_API_Id;
  
  @Column(name = "FULLNAME")
  private String full_name;

  @Column(name = "FIRSTNAME")
  private String firstname;

  @Column(name = "SURNAME")
  private String surname;
  
  @Column(name = "TICKERNAME")
  private String ticker_name;

  @Column(name = "ROLE")
  private String role;
  
  @Column(name = "TEAMID")
  private Integer teamId;
  
  @Column(name = "PHOTO")
  private String photo;
 
  @Transient
  private Integer playerPosition;

  @Transient
  private String captainGoalKeeper;

  @Transient
  private String player_type;

	public PlayersTable() {
		super();
	}

	public PlayersTable(int playerId, Integer playerPosition, String player_type) {
		super();
		this.playerId = playerId;
		this.playerPosition = playerPosition;
		this.player_type = player_type;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayer_API_Id() {
		return player_API_Id;
	}

	public void setPlayer_API_Id(String player_API_Id) {
		this.player_API_Id = player_API_Id;
	}

	public int getJersey_number() {
		return jersey_number;
	}

	public void setJersey_number(int jersey_number) {
		this.jersey_number = jersey_number;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTicker_name() {
		return ticker_name;
	}

	public void setTicker_name(String ticker_name) {
		this.ticker_name = ticker_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(Integer playerPosition) {
		this.playerPosition = playerPosition;
	}

	public String getCaptainGoalKeeper() {
		return captainGoalKeeper;
	}

	public void setCaptainGoalKeeper(String captainGoalKeeper) {
		this.captainGoalKeeper = captainGoalKeeper;
	}

	public String getPlayer_type() {
		return player_type;
	}

	public void setPlayer_type(String player_type) {
		this.player_type = player_type;
	}

	@Override
	public String toString() {
		return "PlayersTable [playerId=" + playerId + ", jersey_number=" + jersey_number + ", player_API_Id="
				+ player_API_Id + ", full_name=" + full_name + ", firstname=" + firstname + ", surname=" + surname
				+ ", ticker_name=" + ticker_name + ", role=" + role + ", teamId=" + teamId + ", photo=" + photo
				+ ", playerPosition=" + playerPosition + ", captainGoalKeeper=" + captainGoalKeeper + ", player_type="
				+ player_type + "]";
	}

	@Override
	public int compareTo(PlayersTable pm) {
		return (int) (this.getPlayerPosition()-pm.getPlayerPosition());
	}
}
