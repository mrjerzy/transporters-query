package com.mrjerz.TransportersQuery.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
 
	private String product; 
	private double price; 
	private double princeMin; 
	private double priceMax;
	private String currencyCode; 
	private float distanceInMeters;
	private int waitingTimeInSeconds;
	private String comment; 
	
	
	public Result(String product, double price, double princeMin, double priceMax, String currencyCode, float distanceInMeters,
			int waitingTimeInSeconds, String comment) {
		this.product = product;
		this.price = price;
		this.princeMin = princeMin;
		this.priceMax = priceMax;
		this.currencyCode = currencyCode; 
		this.distanceInMeters = distanceInMeters;
		this.waitingTimeInSeconds = waitingTimeInSeconds;
		this.comment = comment; 
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
	public String getCurrencyCode() {
		return currencyCode;
	}

	@JsonProperty
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@JsonProperty
	public float getDistanceInMeters() {
		return distanceInMeters;
	}
	
	
	
	@JsonProperty
	public void setDistanceInMeters(float distanceInMeters) {
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


	@JsonProperty
	public String getComment() {
		return comment;
	}

	@JsonProperty
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
