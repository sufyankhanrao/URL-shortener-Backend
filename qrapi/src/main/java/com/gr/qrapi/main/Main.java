package com.gr.qrapi.main;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import com.gr.qrapi.ws.exception.WsExceptionHandler;
import com.gr.qrapi.ws.filter.WsCorsFilter;
import com.gr.qrapi.ws.v1.Url_shortnerResource;

/**
 * This is main configuration file for rest application using rest easy
 */
@ApplicationPath("")
public class Main extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public Main() {
		
		classes.add(Url_shortnerResource.class);
		classes.add(WsExceptionHandler.class);
		classes.add(WsCorsFilter.class);
		
		System.setProperty("jsse.enableSNIExtension", "false");
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
