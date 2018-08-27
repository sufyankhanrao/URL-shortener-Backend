package com.gr.qrapi.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Url implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String longURL;
	private String shortURL;
	private Date startingDate;
	private Date expiryDate;
	private List<Url_Stats> urlStatList;

	public Url() {
	}

	public Url(String longURL, String shortURL) {
		super();
		this.longURL = longURL;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLongURL() {
		return longURL;
	}

	public void setLongURL(String longURL) {
		this.longURL = longURL;
	}

	public String getShortURL() {
		return shortURL;
	}

	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public List<Url_Stats> getUrlStatList() {
		return urlStatList;
	}

	public void setUrlStatList(List<Url_Stats> urlStatList) {
		this.urlStatList = urlStatList;
	}
	

}
