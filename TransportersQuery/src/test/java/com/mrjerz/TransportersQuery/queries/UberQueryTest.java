package com.mrjerz.TransportersQuery.queries;

import org.junit.Test;

import com.mrjerz.TransportersQuery.queries.UberQuery;

import junit.framework.TestCase;

public class UberQueryTest extends TestCase {
	
	@Test 
	public void testExtractPriceFromEstimate() {
		
		UberQuery uberQuery = new UberQuery("","","",0.0f,0.0f,0.0f,0.0f);
		
		String estimateString = "€12.34"; 
		assertEquals(12.34, uberQuery.extractPriceFromEstimate(estimateString, 99.99));
		
		estimateString = "€12.34-23.45"; 
		assertEquals(23.45, uberQuery.extractPriceFromEstimate(estimateString, 99.99));
		
		estimateString = "METERED"; 
		assertEquals(99.99, uberQuery.extractPriceFromEstimate(estimateString, 99.99));
	}
}
