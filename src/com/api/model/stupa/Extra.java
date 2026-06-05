package com.api.model.stupa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Extra {
	
	@JsonProperty("GameScore")
	private String GameScore;
	
	@JsonProperty("subMatchId")
	private int subMatchId;
	
	@JsonProperty("PlayerACountry")
	private String PlayerACountry;
	
	@JsonProperty("ServiceFrom")
	private String ServiceFrom;
	
	@JsonProperty("PlayerBCountry")
	private String PlayerBCountry;
	
	@JsonProperty("MatchWinnerId")
	private int MatchWinnerId;
	
	@JsonProperty("EventName")
	private String EventName;
	
	@JsonProperty("MatchNumber")
	private int MatchNumber;
	
	@JsonProperty("PlayerBHandType")
	private String PlayerBHandType;
	
	@JsonProperty("PlayerBState")
	private String PlayerBState;
	
	@JsonProperty("PlayerAHandType")
	private String PlayerAHandType;
	
	@JsonProperty("PlayerAId")
	private int PlayerAId;
	
	@JsonProperty("TableNo")
	private int TableNo;
	
	@JsonProperty("PlayerBId")
	private int PlayerBId;
	
	@JsonProperty("ServiceBy")
	private int ServiceBy;
	
	@JsonProperty("PlayerBName")
	private String PlayerBName;
	
	@JsonProperty("GameScoreB")
	private int GameScoreB;
	
	@JsonProperty("SetScoreB")
	private int SetScoreB;
   
	@JsonProperty("GameScoreA")
	private int GameScoreA;
	
	@JsonProperty("TournamentName")
	private String TournamentName;
	
	@JsonProperty("GameWinnerId")
	private int GameWinnerId;
	
	@JsonProperty("PlayerBRedCardCount")
	private int PlayerBRedCardCount;
	
	@JsonProperty("PlayerBYellowYardCount")
	private int PlayerBYellowYardCount;
    
	@JsonProperty("SetScoreA")
	private int SetScoreA;
	
	@JsonProperty("PlayerAyellowCardCount")
	private int PlayerAyellowCardCount;
	
	@JsonProperty("GameNumber")
	private int GameNumber;
	
	@JsonProperty("PlayerAName")
	private String PlayerAName;
	
	@JsonProperty("PlayerARedCardCount")
	private int PlayerARedCardCount;
    
	@JsonProperty("winner")
	private String winner;

	public String getGameScore() {
		return GameScore;
	}

	public void setGameScore(String gameScore) {
		GameScore = gameScore;
	}

	public int getSubMatchId() {
		return subMatchId;
	}

	public void setSubMatchId(int subMatchId) {
		this.subMatchId = subMatchId;
	}

	public String getPlayerACountry() {
		return PlayerACountry;
	}

	public void setPlayerACountry(String playerACountry) {
		PlayerACountry = playerACountry;
	}

	public String getServiceFrom() {
		return ServiceFrom;
	}

	public void setServiceFrom(String serviceFrom) {
		ServiceFrom = serviceFrom;
	}

	public String getPlayerBCountry() {
		return PlayerBCountry;
	}

	public void setPlayerBCountry(String playerBCountry) {
		PlayerBCountry = playerBCountry;
	}

	public int getMatchWinnerId() {
		return MatchWinnerId;
	}

	public void setMatchWinnerId(int matchWinnerId) {
		MatchWinnerId = matchWinnerId;
	}

	public String getEventName() {
		return EventName;
	}

	public void setEventName(String eventName) {
		EventName = eventName;
	}

	public int getMatchNumber() {
		return MatchNumber;
	}

	public void setMatchNumber(int matchNumber) {
		MatchNumber = matchNumber;
	}

	public String getPlayerBHandType() {
		return PlayerBHandType;
	}

	public void setPlayerBHandType(String playerBHandType) {
		PlayerBHandType = playerBHandType;
	}

	public String getPlayerBState() {
		return PlayerBState;
	}

	public void setPlayerBState(String playerBState) {
		PlayerBState = playerBState;
	}

	public String getPlayerAHandType() {
		return PlayerAHandType;
	}

	public void setPlayerAHandType(String playerAHandType) {
		PlayerAHandType = playerAHandType;
	}

	public int getPlayerAId() {
		return PlayerAId;
	}

	public void setPlayerAId(int playerAId) {
		PlayerAId = playerAId;
	}

	public int getTableNo() {
		return TableNo;
	}

	public void setTableNo(int tableNo) {
		TableNo = tableNo;
	}

	public int getPlayerBId() {
		return PlayerBId;
	}

	public void setPlayerBId(int playerBId) {
		PlayerBId = playerBId;
	}

	public int getServiceBy() {
		return ServiceBy;
	}

	public void setServiceBy(int serviceBy) {
		ServiceBy = serviceBy;
	}

	public String getPlayerBName() {
		return PlayerBName;
	}

	public void setPlayerBName(String playerBName) {
		PlayerBName = playerBName;
	}

	public int getGameScoreB() {
		return GameScoreB;
	}

	public void setGameScoreB(int gameScoreB) {
		GameScoreB = gameScoreB;
	}

	public int getSetScoreB() {
		return SetScoreB;
	}

	public void setSetScoreB(int setScoreB) {
		SetScoreB = setScoreB;
	}

	public int getGameScoreA() {
		return GameScoreA;
	}

	public void setGameScoreA(int gameScoreA) {
		GameScoreA = gameScoreA;
	}

	public String getTournamentName() {
		return TournamentName;
	}

	public void setTournamentName(String tournamentName) {
		TournamentName = tournamentName;
	}

	public int getGameWinnerId() {
		return GameWinnerId;
	}

	public void setGameWinnerId(int gameWinnerId) {
		GameWinnerId = gameWinnerId;
	}

	public int getPlayerBRedCardCount() {
		return PlayerBRedCardCount;
	}

	public void setPlayerBRedCardCount(int playerBRedCardCount) {
		PlayerBRedCardCount = playerBRedCardCount;
	}

	public int getPlayerBYellowYardCount() {
		return PlayerBYellowYardCount;
	}

	public void setPlayerBYellowYardCount(int playerBYellowYardCount) {
		PlayerBYellowYardCount = playerBYellowYardCount;
	}

	public int getSetScoreA() {
		return SetScoreA;
	}

	public void setSetScoreA(int setScoreA) {
		SetScoreA = setScoreA;
	}

	public int getPlayerAyellowCardCount() {
		return PlayerAyellowCardCount;
	}

	public void setPlayerAyellowCardCount(int playerAyellowCardCount) {
		PlayerAyellowCardCount = playerAyellowCardCount;
	}

	public int getGameNumber() {
		return GameNumber;
	}

	public void setGameNumber(int gameNumber) {
		GameNumber = gameNumber;
	}

	public String getPlayerAName() {
		return PlayerAName;
	}

	public void setPlayerAName(String playerAName) {
		PlayerAName = playerAName;
	}

	public int getPlayerARedCardCount() {
		return PlayerARedCardCount;
	}

	public void setPlayerARedCardCount(int playerARedCardCount) {
		PlayerARedCardCount = playerARedCardCount;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return "Extra [GameScore=" + GameScore + ", subMatchId=" + subMatchId + ", PlayerACountry=" + PlayerACountry
				+ ", ServiceFrom=" + ServiceFrom + ", PlayerBCountry=" + PlayerBCountry + ", MatchWinnerId="
				+ MatchWinnerId + ", EventName=" + EventName + ", MatchNumber=" + MatchNumber + ", PlayerBHandType="
				+ PlayerBHandType + ", PlayerBState=" + PlayerBState + ", PlayerAHandType=" + PlayerAHandType
				+ ", PlayerAId=" + PlayerAId + ", TableNo=" + TableNo + ", PlayerBId=" + PlayerBId + ", ServiceBy="
				+ ServiceBy + ", PlayerBName=" + PlayerBName + ", GameScoreB=" + GameScoreB + ", SetScoreB=" + SetScoreB
				+ ", GameScoreA=" + GameScoreA + ", TournamentName=" + TournamentName + ", GameWinnerId=" + GameWinnerId
				+ ", PlayerBRedCardCount=" + PlayerBRedCardCount + ", PlayerBYellowYardCount=" + PlayerBYellowYardCount
				+ ", SetScoreA=" + SetScoreA + ", PlayerAyellowCardCount=" + PlayerAyellowCardCount + ", GameNumber="
				+ GameNumber + ", PlayerAName=" + PlayerAName + ", PlayerARedCardCount=" + PlayerARedCardCount
				+ ", winner=" + winner + "]";
	}
    
}