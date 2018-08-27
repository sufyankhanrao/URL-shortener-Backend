package com.gr.qrapi.core.dao;

import java.util.List;

import com.gr.common.dao.GenericDao;
import com.gr.qrapi.core.model.Url;
import com.gr.qrapi.core.model.Url_Stats;
import com.gr.qrapi.ws.skeleton.Click_Stat_Model;
import com.gr.qrapi.ws.skeleton.Url_Details;

public interface UrlsDao extends GenericDao<Url, Integer> {

	Url addURL(Url url);

	List<Url> getAllURLs();

	Url searchURLByID(int urlID);
	
	boolean addUrlDetail(Url_Stats url_stats, int UrlID);
	
	List<Click_Stat_Model> getClickStats(int urlID);
	
	Url_Details getURLDetails(int urlID); 
}
