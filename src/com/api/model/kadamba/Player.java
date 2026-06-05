package com.api.model.kadamba;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Column;

@Entity
@Table(name = "Players")
public class Player
{

  @Id
  @Column(name = "PlayerID")
  private int playerId;
  
  @Column(name = "PlayerNumber")
  private int playerNumber;
  
  @Column(name = "FullName")
  private String full_name;

  @Column(name = "FirstName")
  private String firstname;

  @Column(name = "Surname")
  private String surname;
  
  @Column(name = "TickerName")
  private String ticker_name;

  @Column(name = "Role")
  private String role;
  
  @Column(name = "Age")
  private String age;

  @Column(name = "Height")
  private String height;
  
  @Column(name = "Weight")
  private String weight;
  
  @Column(name = "Category")
  private String category;
  
  @Column(name = "Nationality")
  private String nationality;
  
  @Column(name = "BasePrice")
  private String basePrice;
  
  @Column(name = "PhotoName")
  private String photoName;
 
  @Transient
  private int teamId;

  @Transient
  private int soldForPoints;
  
  @Transient
  private String soldOrUnsold;
  
  public Player() {
	 super();
  }

public Player(int playerId, String full_name, int teamId, int soldForPoints, String soldOrUnsold) {
	super();
	this.playerId = playerId;
	this.full_name = full_name;
	this.teamId = teamId;
	this.soldForPoints = soldForPoints;
	this.soldOrUnsold = soldOrUnsold;
}

public int getPlayerId() {
	return playerId;
}

public void setPlayerId(int playerId) {
	this.playerId = playerId;
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

public String getAge() {
	return age;
}

public void setAge(String age) {
	this.age = age;
}

public String getHeight() {
	return height;
}

public void setHeight(String height) {
	this.height = height;
}

public String getWeight() {
	return weight;
}

public void setWeight(String weight) {
	this.weight = weight;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getNationality() {
	return nationality;
}

public void setNationality(String nationality) {
	this.nationality = nationality;
}

public String getBasePrice() {
	return basePrice;
}

public void setBasePrice(String basePrice) {
	this.basePrice = basePrice;
}

public String getPhotoName() {
	return photoName;
}

public void setPhotoName(String photoName) {
	this.photoName = photoName;
}

public int getTeamId() {
	return teamId;
}

public void setTeamId(int teamId) {
	this.teamId = teamId;
}

public int getSoldForPoints() {
	return soldForPoints;
}

public void setSoldForPoints(int soldForPoints) {
	this.soldForPoints = soldForPoints;
}

public String getSoldOrUnsold() {
	return soldOrUnsold;
}

public void setSoldOrUnsold(String soldOrUnsold) {
	this.soldOrUnsold = soldOrUnsold;
}

public int getPlayerNumber() {
	return playerNumber;
}

public void setPlayerNumber(int playerNumber) {
	this.playerNumber = playerNumber;
}

}