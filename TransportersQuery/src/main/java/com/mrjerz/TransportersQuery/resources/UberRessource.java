package com.mrjerz.TransportersQuery.resources;

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

@Path("/uberCheck")
@Produces(MediaType.APPLICATION_JSON)
public class UberRessource {
	
	private double startLatitude; 
	private double startLongitude; 
	private double endLatitude; 
	private double endLongitude; 
	private String uberAccessToken; 
	private String uberServerToken; 
    private final AtomicLong counter;
    
    public UberRessource(String uberAccessToken, String uberServerToken){
		this.uberAccessToken = uberAccessToken; 
		this.uberServerToken = uberServerToken;
		this.counter = new AtomicLong(); 
    }
    
    @GET
	@Timed
	public ResultAPI giveUberResults(@Context UriInfo info){
    		
		startLatitude 	= Double.parseDouble(info.getQueryParameters().getFirst("sLat"));
		startLongitude	= Double.parseDouble(info.getQueryParameters().getFirst("sLong"));
		endLongitude		= Double.parseDouble(info.getQueryParameters().getFirst("eLat"));
		endLongitude		= Double.parseDouble(info.getQueryParameters().getFirst("eLong"));
		
		UberQuery uberQuery = new UberQuery(startLatitude, startLongitude, endLatitude, endLongitude);
		return uberQuery.runQuery(counter.incrementAndGet());
    }
	
}
