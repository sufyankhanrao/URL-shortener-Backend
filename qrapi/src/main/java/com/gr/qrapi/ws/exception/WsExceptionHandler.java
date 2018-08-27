package com.gr.qrapi.ws.exception;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.gr.common.infrastrcture.Infrastructure;
import com.gr.common.logging.Logger;

/**
 * This exception handler is used as handler of generic exceptions
 * 
 * @author ufarooq
 */
@Provider
public class WsExceptionHandler implements ExceptionMapper<Exception> {

	protected Logger logger = Infrastructure.getLogger(getClass().getName());

	@Context
	private HttpServletRequest request;

	@Override
	public Response toResponse(Exception exception) {
		return null;
	}
}