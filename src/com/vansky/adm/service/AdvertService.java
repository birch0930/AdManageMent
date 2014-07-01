package com.vansky.adm.service;

import java.util.List;

import com.vansky.adm.domain.Advert;

public interface AdvertService {

	public void saveAdvert(Advert advert);
	public List<Advert> getAdvertList();
	public void suspend(Advert advert);
	public void resume(Advert advert);
	public int getTotalAds();
	public Advert getAdvert(Advert advert);
	public void updateRemainedDate() ;
}
