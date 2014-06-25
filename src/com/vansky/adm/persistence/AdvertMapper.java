package com.vansky.adm.persistence;

import java.util.List;

import com.vansky.adm.domain.Advert;

public interface AdvertMapper {
	public Advert getAdvertById(int id);
	public List<Advert> getAdvertList();
	public void saveAdvert(Advert a);
	public void delete(Advert a);	
	public void updateAdvert(Advert a);
	public void suspendAdvert(int advertId);
	public void resumeAdvert(int advertId);
}
