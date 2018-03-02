package com.mrjerz.TransportersQuery.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.codahale.metrics.annotation.Timed;
import com.mrjerz.TransportersQuery.api.ResultAPI;
import com.mrjerz.TransportersQuery.queries.UberQuery;
import com.mrjerz.TransportersQuery.api.Result;

@Path("/uberCheck")
@Produces(MediaType.APPLICATION_JSON)
public class UberRessource {
	
	private String uberClientId; 
	private String uberAccessToken; 
	private String uberServerToken; 
	private float startLatitude; 
	private float startLongitude; 
	private float endLatitude; 
	private float endLongitude;
    private final AtomicLong counter;
    
    public UberRessource(String uberClientId, String uberAccessToken, String uberServerToken){
		this.uberClientId = uberClientId; 
    		this.uberAccessToken = uberAccessToken; 
		this.uberServerToken = uberServerToken;
		this.counter = new AtomicLong(); 
    }
    
    @GET
	@Timed
	public ResultAPI giveUberResults(@Context UriInfo info){
    	
    		//TODO: Parameter to be read from Json, instead from URI 
		startLatitude 	= Float.parseFloat(info.getQueryParameters().getFirst("sLat"));
		startLongitude	= Float.parseFloat(info.getQueryParameters().getFirst("sLong"));
		endLatitude	= Float.parseFloat(info.getQueryParameters().getFirst("eLat"));
		endLongitude		= Float.parseFloat(info.getQueryParameters().getFirst("eLong"));
		
		UberQuery uberQuery = new UberQuery(uberClientId, uberAccessToken, uberServerToken, startLatitude, startLongitude, endLatitude, endLongitude);
		
		ResultAPI result = null; 
		
		try {
			result = uberQuery.runQuery(counter.incrementAndGet());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			List<Result> errResList = new ArrayList<Result>(); 
			// errResList.add(new Result("ERROR", 0, 0, 0, "", 0, 0, "No Result")); 
			result = new ResultAPI(0, e.getMessage(), errResList);
		}
		
		return result;
    }
	
}
