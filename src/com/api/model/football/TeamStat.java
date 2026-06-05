package com.api.model.football;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStat {

	@JsonProperty("fh")
	private String fh;
	  
	@JsonProperty("sh")
	private String sh;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("value")
	private String value;

	public TeamStat() {
		super();
	}

	public String getFh() {
		return fh;
	}

	public void setFh(String fh) {
		this.fh = fh;
	}

	public String getSh() {
		return sh;
	}

	public void setSh(String sh) {
		this.sh = sh;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "TeamStat [fh=" + fh + ", sh=" + sh + ", type=" + type + ", value=" + value + "]";
	}

}