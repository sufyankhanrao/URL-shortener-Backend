package com.gr.qrapi.ws.v1;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.gr.qrapi.core.model.Url;
import com.gr.qrapi.core.model.Url_Stats;
import com.gr.qrapi.core.service.GeneralService;
import com.gr.qrapi.core.service.GeneralServiceLocal;
import com.gr.qrapi.ws.skeleton.Click_Stat_Model;
import com.gr.qrapi.ws.skeleton.Url_Details;

import eu.bitwalker.useragentutils.UserAgent;

@Path("/v1/url")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Url_shortnerResource {
	
	GeneralServiceLocal genericService = GeneralService.getService();
	@Context
	UriInfo info;

	@POST
	@Path("/add")
	public Url addURL(Url url) {
		LocalDate today=LocalDate.now();
		url.setStartingDate(Date.valueOf(today));
		url.setExpiryDate(Date.valueOf(today.plusDays(1)));
		return genericService.addURL(url);
	}

	@GET
	@Path("/details")
	public Url_Details searchURLByID(@Context UriInfo info) {
		int urlID = Integer.parseInt(info.getQueryParameters().getFirst("urlID"));
		return genericService.getURLDetails(urlID);
	}

	@GET
	@Path("/get/all")
	public List<Url> getAllURLs() {
		return genericService.getAllURLs();
	}
	
	@SuppressWarnings("unused")
	@GET
	@Path("/redirect")
	public Response redirectToLongUrl(@Context UriInfo info,
			@HeaderParam("user-agent") String userAgentString) {
		String shortUrl = info.getQueryParameters().getFirst("shortURL");
		UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
		String browser = userAgent.getBrowser().getName();
		String platform = userAgent.getOperatingSystem().getName();
		
		Url myURL=genericService.getLongURL(shortUrl);
		URI uriLong=null;
		Response response=null;
		Url_Stats url_stats=null;
		if(myURL!=null) {
			try {
				if(genericService.checkURLExpiry(Date.valueOf(LocalDate.now()), myURL.getExpiryDate())) {
					if(genericService.addUrlDetail(new Url_Stats(Date.valueOf(LocalDate.now()), browser, platform),myURL.getId())) {
						uriLong = new URI(myURL.getLongURL());
						response = Response.seeOther(uriLong).build();
					}
				}else {
					uriLong = new URI("http://localhost:4200/expirypage");
					response = Response.seeOther(uriLong).build();
				}
			} catch (URISyntaxException e) {
				e.printStackTrace();
				return Response.serverError().build();
			}
		}else {
			try {
				uriLong = new URI("https://localhost:4200/errorpage");
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response = Response.seeOther(uriLong).build();
		}
		
		return response;	
	}
	
	@GET
	@Path("/get/stats")
	public List<Click_Stat_Model> getURLClickStats(@Context UriInfo info) {
		int urlID = Integer.parseInt(info.getQueryParameters().getFirst("urlID"));
		return genericService.getClickStats(urlID);
	}
	

}
