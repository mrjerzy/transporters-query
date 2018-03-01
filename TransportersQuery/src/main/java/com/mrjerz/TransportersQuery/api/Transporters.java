package com.mrjerz.TransportersQuery.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transporters {
	
	private String transporterName;
	private List<Result> results;
	
	public Transporters(String transporterName, List<Result> results) {
		this.transporterName = transporterName;
		this.results = results;
	}

	@JsonProperty
	public String getTransporterName() {
		return transporterName;
	}

	@JsonProperty
	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}	

	@JsonProperty
	public List<Result> getResults() {
		return results;
	}

	@JsonProperty
	public void setResults(List<Result> results) {
		this.results = results;
	} 
	
}
