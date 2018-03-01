package com.mrjerz.TransportersQuery.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
 
	private String product; 
	private double price; 
	private double princeMin; 
	private double priceMax;
	private int distanceInMeters; 
	private int waitingTimeInSeconds;
	
	
	
	public Result(String product, double price, double princeMin, double priceMax, int distanceInMeters,
			int waitingTimeInSeconds) {
		this.product = product;
		this.price = price;
		this.princeMin = princeMin;
		this.priceMax = priceMax;
		this.distanceInMeters = distanceInMeters;
		this.waitingTimeInSeconds = waitingTimeInSeconds;
	}

	@JsonProperty
	public String getProduct() {
		return product;
	}
	
	@JsonProperty
	public void setProduct(String product) {
		this.product = product;
	}
	
	@JsonProperty
	public double getPrice() {
		return price;
	}
	
	@JsonProperty
	public void setPrice(double price) {
		this.price = price;
	}
	
	@JsonProperty
	public double getPrinceMin() {
		return princeMin;
	}
	
	@JsonProperty
	public void setPrinceMin(double princeMin) {
		this.princeMin = princeMin;
	}
	
	@JsonProperty
	public double getPriceMax() {
		return priceMax;
	}
	
	@JsonProperty
	public void setPriceMax(double priceMax) {
		this.priceMax = priceMax;
	}
	
	@JsonProperty
	public int getDistanceInMeters() {
		return distanceInMeters;
	}
	
	@JsonProperty
	public void setDistanceInMeters(int distanceInMeters) {
		this.distanceInMeters = distanceInMeters;
	}
	
	@JsonProperty
	public int getWaitingTimeInSeconds() {
		return waitingTimeInSeconds;
	}
	
	@JsonProperty
	public void setWaitingTimeInSeconds(int waitingTimeInSeconds) {
		this.waitingTimeInSeconds = waitingTimeInSeconds;
	}

}
