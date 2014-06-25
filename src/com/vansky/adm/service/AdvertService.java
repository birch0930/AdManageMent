package com.vansky.adm.service;

import java.util.List;

import com.vansky.adm.domain.Advert;

public interface AdvertService {
	public Advert getAdvertById(int id);
	public void saveAdvert(Advert advert);
	public List<Advert> getAdvertList();
	public void suspendAdById(int advertId);
	public void resumeAdById(int advertId);
}
