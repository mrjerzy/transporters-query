package com.mrjerz.TransportersQuery.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransportersConfig {

	private UberConfig uberConfig;

	@JsonProperty
	public UberConfig getUberConfig() {
		return uberConfig;
	}

	@JsonProperty
	public void setUberConfig(UberConfig uberConfig) {
		this.uberConfig = uberConfig;
	} 
	
	
}
