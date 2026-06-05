package com.api.model.football;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Messages {
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("message")
	private List<Message> message;

	public Messages() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Messages [state=" + state + ", message=" + message + "]";
	}

}
