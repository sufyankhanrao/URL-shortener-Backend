package com.gr.qrapi.core.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.gr.qrapi.core.model.Url;
import com.gr.qrapi.core.model.Url_Stats;
import com.gr.qrapi.ws.skeleton.Click_Stat_Model;
import com.gr.qrapi.ws.skeleton.Url_Details;

@Local
public interface GeneralServiceLocal {
	Url addURL(Url url);

	List<Url> getAllURLs();
	
	Url getLongURL(String ShortURL);
	
	boolean addUrlDetail(Url_Stats url_stats, int urlID);
	
	boolean checkURLExpiry(Date clickDate,Date expiryDate);
	
	List<Click_Stat_Model> getClickStats(int urlID);
	
	Url_Details getURLDetails(int urlID); 
}
