package com.api.model.football;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Insight {
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("contestantId")
	private String contestantId;
	
	@JsonProperty("timeMin")
	private String timeMin;
	
	@JsonProperty("timeSec")
	private String timeSec;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getContestantId() {
		return contestantId;
	}

	public void setContestantId(String periodId) {
		this.contestantId = periodId;
	}

	public String getTimeMin() {
		return timeMin;
	}

	public void setTimeMin(String timeMin) {
		this.timeMin = timeMin;
	}

	public String getTimeSec() {
		return timeSec;
	}

	public void setTimeSec(String timeSec) {
		this.timeSec = timeSec;
	}

	public Insight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Insight(String text, String contestantId, String timeMin, String timeSec) {
		super();
		this.text = text;
		this.contestantId = contestantId;
		this.timeMin = timeMin;
		this.timeSec = timeSec;
	}

}
