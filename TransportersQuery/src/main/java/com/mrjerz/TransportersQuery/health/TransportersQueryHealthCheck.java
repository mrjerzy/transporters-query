package com.mrjerz.TransportersQuery.health;

import com.codahale.metrics.health.HealthCheck;

public class TransportersQueryHealthCheck extends HealthCheck{

	@Override
	protected Result check() throws Exception {
		// TODO Healthcheck to be implemented
		return Result.healthy();
	}

}
