package com.mrjerz.TransportersQuery;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mrjerz.TransportersQuery.config.TransportersConfig;

import io.dropwizard.Configuration;

public class TransportersQueryConfiguration extends Configuration{

	private TransportersConfig transportersConfig;

	@JsonProperty
	public TransportersConfig getTransportersConfig() {
		return transportersConfig;
	}

	@JsonProperty
	public void setTransportersConfig(TransportersConfig transportersConfig) {
		this.transportersConfig = transportersConfig;
	} 
	
	
	
}
