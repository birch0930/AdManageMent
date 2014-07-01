package com.vansky.adm.persistence;

import java.util.List;

import com.vansky.adm.domain.Advert;

public interface AdvertMapper {
	public Advert getAdvert(Advert advert);
	public List<Advert> getAdvertList();
	public void saveAdvert(Advert advert);
	public void delete(Advert advert);	
	public void updateAdvert(Advert advert);
	public void suspendAdvert(Advert advert);
	public void resumeAdvert(Advert advert);
	public void updateRemainedDate(Advert advert);
}
