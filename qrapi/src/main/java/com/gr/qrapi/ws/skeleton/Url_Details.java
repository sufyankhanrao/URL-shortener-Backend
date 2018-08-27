package com.gr.qrapi.ws.skeleton;

public class Url_Details {
	String shortURL;
	String date;
	String longURL;
	Integer urlClicks;
	
	public Url_Details(String shortURL, String date, String longURL, Integer urlClicks) {
		super();
		this.shortURL = shortURL;
		this.date = date;
		this.longURL = longURL;
		this.urlClicks = urlClicks;
	}
	public Integer getUrlClicks() {
		return urlClicks;
	}
	public void setUrlClicks(Integer urlClicks) {
		this.urlClicks = urlClicks;
	}
	public String getShortURL() {
		return shortURL;
	}
	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLongURL() {
		return longURL;
	}
	public void setLongURL(String longURL) {
		this.longURL = longURL;
	}
	
	
}
