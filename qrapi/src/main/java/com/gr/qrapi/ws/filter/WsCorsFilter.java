package com.gr.qrapi.ws.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.gr.qrapi.common.Constants;

/**
 * This filter handles CORS
 * 
 * @author ufarooq
 */
@PreMatching
@Provider
public class WsCorsFilter implements ContainerRequestFilter, ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException
	{
		if (requestContext.getMethod().equalsIgnoreCase("OPTIONS"))
		{
			Response.ResponseBuilder builder = Response.ok();
			requestContext.abortWith(builder.build());
		}
	}	
	
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {

		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH");
		responseContext.getHeaders().add("Access-Control-Allow-Headers", this.getAllowedHeaders());
		responseContext.getHeaders().add("Access-Control-Expose-Headers", this.getAllowedHeaders());
	}

	private String getAllowedHeaders() {
		StringBuilder sb = new StringBuilder();
		sb.append(HttpHeaders.ACCEPT).append(", ")
		.append(HttpHeaders.CONTENT_TYPE).append(", ")
		.append(HttpHeaders.AUTHORIZATION).append(", ")
		.append(Constants.HEADER_X_SOURCE).append(", ")
		.append(Constants.HEADER_X_USERNAME).append(", ")
		.append(Constants.HEADER_X_PASSWORD).append(", ")
		.append(Constants.HEADER_X_REQUEST_CODE);

		return sb.toString();
	}
}
