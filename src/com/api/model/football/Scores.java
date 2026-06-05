package com.api.model.football;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Scores {

	@JsonProperty("ht")
	private HalfTime ht;
	  
	@JsonProperty("ft")
	private FullTime ft;
	
	@JsonProperty("total")
	private TotalTime total;

	public Scores() {
		super();
	}

	public HalfTime getHt() {
		return ht;
	}

	public void setHt(HalfTime ht) {
		this.ht = ht;
	}

	public FullTime getFt() {
		return ft;
	}

	public void setFt(FullTime ft) {
		this.ft = ft;
	}

	public TotalTime getTotal() {
		return total;
	}

	public void setTotal(TotalTime total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Scores [ht=" + ht + ", ft=" + ft + ", total=" + total + "]";
	}
	
}