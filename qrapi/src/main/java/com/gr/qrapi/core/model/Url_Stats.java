package com.gr.qrapi.core.model;

import java.io.Serializable;
import java.util.Date;

public class Url_Stats implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date clickDate;
	private String browser;
	private String platform;

	public Url_Stats() {
	}
	
	public Url_Stats(Date clickDate, String browser, String platform) {
		super();
		this.clickDate = clickDate;
		this.browser = browser;
		this.platform = platform;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getClickDate() {
		return clickDate;
	}

	public void setClickDate(Date clickDate) {
		this.clickDate = clickDate;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	

}
