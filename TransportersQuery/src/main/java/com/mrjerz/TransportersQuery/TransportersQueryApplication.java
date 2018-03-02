package com.mrjerz.TransportersQuery;

import java.util.logging.Logger;

import com.mrjerz.TransportersQuery.health.TransportersQueryHealthCheck;
import com.mrjerz.TransportersQuery.resources.UberRessource;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;


public class TransportersQueryApplication extends Application<TransportersQueryConfiguration>
{
	
	private final static Logger LOGGER = Logger.getLogger("TransportersQueryApplication");
	
    public static void main(String[] args) throws Exception {
        new TransportersQueryApplication().run(args);
    }


	@Override
	public void run(TransportersQueryConfiguration configuration, Environment environment) throws Exception {
	
		LOGGER.info("Configuration is being read");
		
		String uberClientId 		= configuration.getTransportersConfig().getUberConfig().getUberClientId();  
		String uberAccessToken 	= configuration.getTransportersConfig().getUberConfig().getUberAccessToken(); 
		String uberServerToken 	= configuration.getTransportersConfig().getUberConfig().getUberServerToken();
		
		
		LOGGER.info("UberClientId:" + uberClientId); 
		LOGGER.info("UberAccessToken:" + uberAccessToken); 
		LOGGER.info("UberServerToken:" + uberServerToken); 
	 
	
		
		final TransportersQueryHealthCheck healthCheck = new TransportersQueryHealthCheck(); 
		environment.healthChecks().register("Main Health Check", healthCheck);
		final UberRessource uberResource = new UberRessource(uberClientId, uberAccessToken, uberServerToken); 
		environment.jersey().register(uberResource);
	}
}
