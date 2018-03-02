package com.mrjerz.TransportersQuery.util;

public final class Converter {

	private final static double MILES_TO_METER_FACTOR = 1609.344;  
	
	
	public static double metersToMiles(double meters) {
		return meters / MILES_TO_METER_FACTOR; 
	}
	
	public static double milesToMeters(double miles) {
		return miles * MILES_TO_METER_FACTOR;
	}
}
