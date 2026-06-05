package com.api.model.stupa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Competition {
	
	@JsonProperty("actions")
	private Action actions;
	
	@JsonProperty("extendedInfos")
	private Info extendedInfos;

	public Action getActions() {
		return actions;
	}

	public void setActions(Action actions) {
		this.actions = actions;
	}

	public Info getExtendedInfos() {
		return extendedInfos;
	}

	public void setExtendedInfos(Info extendedInfos) {
		this.extendedInfos = extendedInfos;
	}

	@Override
	public String toString() {
		return "Competition [actions=" + actions + ", extendedInfos=" + extendedInfos + "]";
	}
	  
}