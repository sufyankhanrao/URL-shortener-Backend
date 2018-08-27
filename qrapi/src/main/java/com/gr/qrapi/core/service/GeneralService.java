package com.gr.qrapi.core.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import com.gr.common.service.ServiceManager;
import com.gr.qrapi.core.dao.UrlsDaoHibernateImpl;
import com.gr.qrapi.core.model.Url;
import com.gr.qrapi.core.model.Url_Stats;
import com.gr.qrapi.ws.skeleton.Click_Stat_Model;
import com.gr.qrapi.ws.skeleton.Url_Details;

@Stateless
public class GeneralService implements GeneralServiceLocal {

	public static GeneralServiceLocal getService() {
		return (GeneralServiceLocal) ServiceManager.getService(GeneralServiceLocal.class);
	}

	// Account CRUD Operations starts here

	@Override
	public List<Url> getAllURLs() {
		return UrlsDaoHibernateImpl.getDao().getAllURLs();
	}

	@Override
	public Url addURL(Url url) {
		return UrlsDaoHibernateImpl.getDao().addURL(url);
	}

	@Override
	public Url getLongURL(String ShortURL) {
		int urlID=0;
		try {
			urlID=Integer.parseInt(ShortURL.substring(ShortURL.lastIndexOf("r")+1),16);
		}catch(NumberFormatException ne) {
			System.out.println("API Error!");
		}
		return UrlsDaoHibernateImpl.getDao().searchURLByID(urlID);
	}

	@Override
	public boolean addUrlDetail(Url_Stats url_stats, int urlID) {
		return UrlsDaoHibernateImpl.getDao().addUrlDetail(url_stats,urlID);
	}

	public boolean checkURLExpiry(Date clickDate, Date expiryDate) {
		if(clickDate.compareTo(expiryDate)<=0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Click_Stat_Model> getClickStats(int urlID) {
		return UrlsDaoHibernateImpl.getDao().getClickStats(urlID);
	}

	@Override
	public Url_Details getURLDetails(int urlID) {
		return UrlsDaoHibernateImpl.getDao().getURLDetails(urlID);
	}
}
