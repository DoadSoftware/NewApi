package com.api.model.football;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class competition {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("knownName")
	private String knownName;
	
	@JsonProperty("competitionFormat")
	private String competitionFormat;
	
	@JsonProperty("name")
	private String name;

	public competition() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKnownName() {
		return knownName;
	}

	public void setKnownName(String knownName) {
		this.knownName = knownName;
	}

	public String getCompetitionFormat() {
		return competitionFormat;
	}

	public void setCompetitionFormat(String competitionFormat) {
		this.competitionFormat = competitionFormat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "competition [id=" + id + ", knownName=" + knownName + ", competitionFormat=" + competitionFormat
				+ ", name=" + name + "]";
	}
}