package com.gr.qrapi.ws.exception;

import java.io.Serializable;

/**
 * This is generic Exception thrown in case any Exception is thrown
 * 
 * @author ufarooq
 */
public class WsException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public WsException() {
		super();
	}
}