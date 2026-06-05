package com.api.model.football;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassMatrix {

	@JsonProperty("matchInfo")
	private MatchInfo matchInfo;
	
	@JsonProperty("liveData")
	private LiveData liveData;
	
	@JsonProperty("playerRatings")
	private PlayerRating playerRatings;


	@JsonProperty("lineUp")
	private List<LineUp> lineUp;
	
	@JsonProperty("messages")
	private List<Messages> messages;
	
	@JsonProperty("insight")
	private List<Insight> insight;
	
	@JsonProperty("possessionValue")
	private List<possessionValue> possessionValue;
	
	public PassMatrix() {
		super();
	}

	public MatchInfo getMatchInfo() {
		return matchInfo;
	}

	public void setMatchInfo(MatchInfo matchInfo) {
		this.matchInfo = matchInfo;
	}

	public LiveData getLiveData() {
		return liveData;
	}

	public void setLiveData(LiveData liveData) {
		this.liveData = liveData;
	}

	public List<possessionValue> getPossessionValue() {
		return possessionValue;
	}

	public void setPossessionValue(List<possessionValue> possessionValue) {
		this.possessionValue = possessionValue;
	}

	public PlayerRating getPlayerRatings() {
		return playerRatings;
	}

	public void setPlayerRatings(PlayerRating playerRatings) {
		this.playerRatings = playerRatings;
	}

	public List<LineUp> getLineUp() {
		return lineUp;
	}

	public void setLineUp(List<LineUp> lineUp) {
		this.lineUp = lineUp;
	}

	public List<Insight> getInsight() {
		return insight;
	}

	public void setInsight(List<Insight> insight) {
		this.insight = insight;
	}

	public List<Messages> getMessages() {
		return messages;
	}

	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "PassMatrix [matchInfo=" + matchInfo + ", liveData=" + liveData + ", playerRatings=" + playerRatings
				+ ", lineUp=" + lineUp + ", messages=" + messages + ", insight=" + insight + ", possessionValue="
				+ possessionValue + "]";
	}

}
