package com.vansky.adm.service.impl;


import java.util.List;

import com.vansky.adm.persistence.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;



import com.vansky.adm.domain.Advert;
import com.vansky.adm.service.AdvertService;

@Service("advertService")
public class AdvertServiceImpl implements AdvertService {

	@Autowired
	private AdvertMapper AdvertMapper;

	

	@Transactional
	@Override
	public void saveAdvert(Advert advert) {
		AdvertMapper.saveAdvert(advert);		
	}
	public AdvertMapper getAdvertMapper() {
		return AdvertMapper;
	}
	public void setAdvertMapper(AdvertMapper advertMapper) {
		AdvertMapper = advertMapper;
	}
	
	@Override
	public Advert getAdvertById(int id) {
		return AdvertMapper.getAdvertById(id);
	}
	@Transactional
	@Override
	public List<Advert> getAdvertList() {
		
		return AdvertMapper.getAdvertList();
	}
	
	@Override
	public void suspendAdById(int advertId) {
		AdvertMapper.suspendAdvert(advertId);
	}
	@Override
	public void resumeAdById(int advertId) {
		AdvertMapper.resumeAdvert(advertId);	
	}
	
	
}
