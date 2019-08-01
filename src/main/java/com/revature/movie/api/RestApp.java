package com.revature.movie.api;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("v1")
public class RestApp extends ResourceConfig {
	public RestApp() {
		packages("com.revature.movie.api.resources");
	}
}