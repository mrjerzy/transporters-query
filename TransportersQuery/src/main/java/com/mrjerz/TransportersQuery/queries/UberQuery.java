package com.mrjerz.TransportersQuery.queries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mrjerz.TransportersQuery.api.Result;
import com.mrjerz.TransportersQuery.api.ResultAPI;
import com.mrjerz.TransportersQuery.util.Converter;
import com.uber.sdk.rides.client.ServerTokenSession;
import com.uber.sdk.rides.client.SessionConfiguration;
import com.uber.sdk.rides.client.UberRidesApi;
import com.uber.sdk.rides.client.model.PriceEstimate;
import com.uber.sdk.rides.client.model.PriceEstimatesResponse;
import com.uber.sdk.rides.client.services.RidesService;

import retrofit2.Call;
import retrofit2.Response;

public class UberQuery implements TransportersQuery{
	
	private String uberClientId; 
	private String uberAccessToken; 
	private String uberServerToken; 
	private float startLatitude; 
	private float startLongitude; 
	private float endLatitude; 
	private float endLongitude; 
	
	// Uber session variables 
	SessionConfiguration uberSessionConfig;
	ServerTokenSession uberSession; 
	UberRidesApi uberRidesApi; 
	RidesService uberRidesService; 
	
	public UberQuery(String uberClientId, String uberAccessToken, String uberServerToken, float startLatitude,
			float startLongitude, float endLatitude, float endLongitude) {
		this.uberClientId = uberClientId;
		this.uberAccessToken = uberAccessToken;
		this.uberServerToken = uberServerToken;
		this.startLatitude = startLatitude;
		this.startLongitude = startLongitude;
		this.endLatitude = endLatitude;
		this.endLongitude = endLongitude;
	}

	public ResultAPI runQuery(long id) throws Exception{
		
		// generate uber configuration 
		uberSessionConfig = new SessionConfiguration.Builder().setClientId(uberClientId).setServerToken(uberServerToken).build();
		// create Uber session 
		uberSession = new ServerTokenSession(uberSessionConfig);
		uberRidesApi = UberRidesApi.with(uberSession).build(); 
		uberRidesService = uberRidesApi.createService(); 
		
		List<Result> resultList = new ArrayList<Result>(); 
		
		// Query Price Estimate from Uber
		Response<PriceEstimatesResponse> priceEstimateResponse = uberRidesService.getPriceEstimates(startLatitude, startLongitude, endLatitude, endLongitude).execute();
		if(!priceEstimateResponse.isSuccessful()) {
			throw new Exception("uberQuery not successful: " 
			+ priceEstimateResponse.message().toString() + " "
			+ "startLatitude:" + startLatitude + " "
			+ "startLongitude:" + startLongitude + " " 
			+ "endLatitude:" + endLatitude + " "
			+ "endLongitude:" + endLongitude + " ");
		}
		List<PriceEstimate> estimates = priceEstimateResponse.body().getPrices(); 
		
		for (int i=0; i<= estimates.size()-1; i++) {
			resultList.add(new Result(
					estimates.get(i).getDisplayName(), 
					extractPriceFromEstimate(estimates.get(i).getEstimate(), estimates.get(i).getHighEstimate()), 
					estimates.get(i).getLowEstimate(),
					estimates.get(i).getHighEstimate(), 
					estimates.get(i).getCurrencyCode(),
					(float) Converter.milesToMeters(estimates.get(i).getDistance()),
					estimates.get(i).getDuration(),
					estimates.get(i).getEstimate()
					));
			
					//TODO: Implement time Estimate
		}
				
		return new ResultAPI(id, "Uber", resultList);		
	}
	
	public double extractPriceFromEstimate(String estimateString, double elsePrice) {
		
		/* 
		 * Uber Estimates can be provided in 3 differnt styles: 
		 * Style1: "€12.34"
		 * Style2: “€12.43-53.13.34" 
		 * Style3: "METERED" or similar 
		 */
		
		
		// Validating Style 1 
		Pattern pattern = Pattern.compile("^[€$][0-9]+.[0-9]+$"); 
		Matcher matcher = pattern.matcher(estimateString);
		
		if(matcher.find()) {
			return Double.parseDouble(estimateString.substring(1, estimateString.length()));
		}else { 
			// Validating Style 2
			pattern = Pattern.compile("^[€$][0-9]+.[0-9]+-[0-9]+.[0-9]+$"); 
			matcher = pattern.matcher(estimateString);
			
			if(matcher.find()) {
				int indexOfDash = estimateString.indexOf("-"); 
				return Double.parseDouble(estimateString.substring(indexOfDash + 1, estimateString.length()));
			}else {
				// Style 3
				return elsePrice; 
			}
		}
	}
}
