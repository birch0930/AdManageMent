package com.vansky.adm.domain;

import java.io.Serializable;
import java.util.Date;

public class Advert implements Serializable {
	private int advertId;
	private String username;
	//private int advertTypeId;
	private Date startDate;
	private Date expiryDate;
	private int servicePeriod;
	private int remainedPeriod;
	private Date suspendDate;
	private Date resumeDate;
	private int status;

	public Advert() {

	}


	

	public Advert(int advertId, String username, Date startDate,
			Date expiryDate, int servicePeriod, int remainedPeriod, int status) {
		super();
		this.advertId = advertId;
		this.username = username;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.servicePeriod = servicePeriod;
		this.remainedPeriod = remainedPeriod;
		this.status = status;
	}




	public int getAdvertId() {
		return advertId;
	}

	public void setAdvertId(int advertId) {
		this.advertId = advertId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getServicePeriod() {
		return servicePeriod;
	}

	public void setServicePeriod(int servicePeriod) {
		this.servicePeriod = servicePeriod;
	}

	/*
	 * 
	 * public int getAdvertTypeId() {
	 * 
	 * return advertTypeId; } public void setAdvertTypeId(int advertTypeId) {
	 * this.advertTypeId = advertTypeId; }
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public int getRemainedPeriod() {
		return remainedPeriod;
	}

	public void setRemainedPeriod(int remainedPeriod) {
		this.remainedPeriod = remainedPeriod;
	}


	public Date getResumeDate() {
		return resumeDate;
	}


	public void setResumeDate(Date resumeDate) {
		this.resumeDate = resumeDate;
	}




	public Date getSuspendDate() {
		return suspendDate;
	}




	public void setSuspendDate(Date suspendDate) {
		this.suspendDate = suspendDate;
	}



 
}
