package com.api.model.football;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Goal {

	@JsonProperty("contestantId")
	private String contestantId;
	  
	@JsonProperty("periodId")
	private int periodId;
	
	@JsonProperty("timeMin")
	private int timeMin;

	@JsonProperty("timeMinSec")
	private String timeMinSec;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("scorerId")
	private String scorerId;
	
	@JsonProperty("scorerName")
	private String scorerName;
	
	@JsonProperty("assistPlayerId")
	private String assistPlayerId;
	
	@JsonProperty("assistPlayerName")
	private String assistPlayerName;
	
	@JsonProperty("optaEventId")
	private String optaEventId;
	
	@JsonProperty("homeScore")
	private int homeScore;
	
	@JsonProperty("awayScore")
	private int awayScore;

	public Goal() {
		super();
	}

	public String getContestantId() {
		return contestantId;
	}

	public void setContestantId(String contestantId) {
		this.contestantId = contestantId;
	}

	public int getPeriodId() {
		return periodId;
	}

	public void setPeriodId(int periodId) {
		this.periodId = periodId;
	}

	public int getTimeMin() {
		return timeMin;
	}

	public void setTimeMin(int timeMin) {
		this.timeMin = timeMin;
	}

	public String getTimeMinSec() {
		return timeMinSec;
	}

	public void setTimeMinSec(String timeMinSec) {
		this.timeMinSec = timeMinSec;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getScorerId() {
		return scorerId;
	}

	public void setScorerId(String scorerId) {
		this.scorerId = scorerId;
	}

	public String getScorerName() {
		return scorerName;
	}

	public void setScorerName(String scorerName) {
		this.scorerName = scorerName;
	}

	public String getOptaEventId() {
		return optaEventId;
	}

	public void setOptaEventId(String optaEventId) {
		this.optaEventId = optaEventId;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}

	public String getAssistPlayerId() {
		return assistPlayerId;
	}

	public void setAssistPlayerId(String assistPlayerId) {
		this.assistPlayerId = assistPlayerId;
	}

	public String getAssistPlayerName() {
		return assistPlayerName;
	}

	public void setAssistPlayerName(String assistPlayerName) {
		this.assistPlayerName = assistPlayerName;
	}

	@Override
	public String toString() {
		return "Goal [contestantId=" + contestantId + ", periodId=" + periodId + ", timeMin=" + timeMin
				+ ", timeMinSec=" + timeMinSec + ", type=" + type + ", scorerId=" + scorerId + ", scorerName="
				+ scorerName + ", assistPlayerId=" + assistPlayerId + ", assistPlayerName=" + assistPlayerName
				+ ", optaEventId=" + optaEventId + ", homeScore=" + homeScore + ", awayScore=" + awayScore + "]";
	}

}