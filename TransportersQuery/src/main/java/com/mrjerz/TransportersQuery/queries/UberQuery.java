package com.mrjerz.TransportersQuery.queries;

import java.util.ArrayList;
import java.util.List;

import com.mrjerz.TransportersQuery.api.Result;
import com.mrjerz.TransportersQuery.api.ResultAPI;

public class UberQuery implements TransportersQuery{
	
	private double startLatitude; 
	private double startLongitude; 
	private double endLatitude; 
	private double endLongitude; 
		
	public UberQuery(double startLatitude, double startLongitude, double endLatitude, double endLongitude) {
		super();
		this.startLatitude = startLatitude;
		this.startLongitude = startLongitude;
		this.endLatitude = endLatitude;
		this.endLongitude = endLongitude;
	}

	public ResultAPI runQuery(long id) {
		
		//FIXME implement call against Uber API
		Result res1 = new Result("Uber X", 12.3, 11.3, 12.3, 950, 300); 
		Result res2 = new Result("Uber Van", 17.5, 16.6, 17.5, 1530, 530); 
		Result res3 = new Result("Uber Black", 20.8, 17.4, 20.8, 370, 150);  
		
		List<Result> resultList = new ArrayList<Result>(); 
		resultList.add(res1); 
		resultList.add(res2); 
		resultList.add(res3); 
		
		return new ResultAPI(id, "Uber", resultList);		
		
	}
	
}
