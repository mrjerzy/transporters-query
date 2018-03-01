package com.mrjerz.TransportersQuery.api;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultAPI {

	private long id; 
	private Transporters transporters;
	
	
	
	public ResultAPI(long id, Transporters transporters) {
		this.id = id;
		this.transporters = transporters;
	}
	
	public ResultAPI(long id, String transporterName, List<Result> results) {
		this.id = id; 
		this.transporters = new Transporters(transporterName, results); 
	}

	@JsonProperty
	public long getId() {
		return id;
	}

	@JsonProperty
	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty
	public Transporters getTransporters() {
		return transporters;
	}
	
	@JsonProperty
	public void setTransporters(Transporters transporters) {
		this.transporters = transporters;
	} 

}
