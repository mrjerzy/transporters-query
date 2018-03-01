package com.mrjerz.TransportersQuery.config;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UberConfig {
	
	@NotEmpty
	private String uberAccessToken; 
	
	@NotEmpty
	private String uberServerToken;
	
	@JsonProperty
	public String getUberAccessToken() {
		return uberAccessToken;
	}
	
	@JsonProperty
	public void setUberAccessToken(String uberAccessToken) {
		this.uberAccessToken = uberAccessToken;
	}
	
	@JsonProperty
	public String getUberServerToken() {
		return uberServerToken;
	}
	
	@JsonProperty
	public void setUberServerToken(String uberServerToken) {
		this.uberServerToken = uberServerToken;
	} 

}
