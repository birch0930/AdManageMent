package com.vansky.adm.service.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vansky.adm.domain.Advert;
import com.vansky.adm.persistence.AdvertMapper;
import com.vansky.adm.service.AdvertService;

@Service("advertService")
public class AdvertServiceImpl implements AdvertService {

	@Autowired
	private AdvertMapper AdvertMapper;

	public AdvertMapper getAdvertMapper() {
		return AdvertMapper;
	}
	public void setAdvertMapper(AdvertMapper advertMapper) {
		AdvertMapper = advertMapper;
	}
	

	@Transactional
	@Override
	public void saveAdvert(Advert advert) {
		AdvertMapper.saveAdvert(advert);		
	}
	
	
	@Override
	public Advert getAdvert(Advert advert) {
		return AdvertMapper.getAdvert(advert);
	}

	@Override
	public List<Advert> getAdvertList() {
		return AdvertMapper.getAdvertList();
	}
	
	
	@Override
	public void suspend(Advert advert) {
		advert.setSuspendDate(new Date());
		AdvertMapper.suspendAdvert(advert);	
	}
	
	@Override
	//remainedDate =  expiryedate - today
	//expiryedate =  expiryedate  + (today - startsuspenddate)
	public void resume(Advert advert) {
		advert = AdvertMapper.getAdvert(advert);
		int suspendPeriod=0;
		try {
			suspendPeriod = daysBetween(advert.getSuspendDate(),new Date());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();	
		cal.setTime(advert.getExpiryDate());
		cal.add(Calendar.DATE, suspendPeriod);
		advert.setExpiryDate(new Date(cal.getTimeInMillis()));
		try {
			advert.setRemainedPeriod(daysBetween(new Date(),advert.getExpiryDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AdvertMapper.resumeAdvert(advert);	
	}
	
	


		
		/** 
	     * 计算两个日期之间相差的天数 
	     * @param smdate 较小的时间
	     * @param bdate  较大的时间
	     * @return 相差天数
		 * @throws ParseException 
	     */  
	    public int daysBetween(Date smdate,Date bdate) throws ParseException  
	    {  
	    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    	smdate=sdf.parse(sdf.format(smdate));
	    	bdate=sdf.parse(sdf.format(bdate));
	        Calendar cal = Calendar.getInstance();  
	        cal.setTime(smdate);  
	        long time1 = cal.getTimeInMillis();               
	        cal.setTime(bdate);  
	        long time2 = cal.getTimeInMillis();       
	        long between_days=(time2-time1)/(1000*3600*24);
	          
	       return Integer.parseInt(String.valueOf(between_days));         
	    }
	    
	    
	    public void updateRemainedDate(){
	    	Iterator<Advert> list =  getAdvertList().iterator();
	    	while(list.hasNext()){
	    		Advert advert = list.next();
	    		if(advert.getStatus() == 1){
	    			if( advert.getRemainedPeriod()>=0){
						try {
							advert.setRemainedPeriod(daysBetween(new Date(), advert.getExpiryDate()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    			}		
	    			else if( advert.getRemainedPeriod()< 0 && advert.getStatus() != -1){
						advert.setStatus(-1);
					}
	    			AdvertMapper.updateRemainedDate(advert);
	    		}
	    		
	    	}
	    
	    	
	    }
	    
	    
		@Override
		public int getTotalAds() {
			return AdvertMapper.getAdvertList().size();
		}  
	    

	

	
	
}
