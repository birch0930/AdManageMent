package com.vansky.adm.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vansky.adm.domain.Advert;
import com.vansky.adm.service.AdvertService;

public class AdvertServiceImplTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-config.xml");				
		AdvertService service = (AdvertService)ctx.getBean("advertService");
		//Advert a = new Advert(1,"admin",new Date(),new Date(),90,90,1);
		Calendar cal = Calendar.getInstance();
		 Calendar cal2 = Calendar.getInstance();
	   
	   
	    
	    int days = (int) ((cal2.getTimeInMillis()- new Date().getTime())/(1000*3600*24));
	    for (int i = 0; i < 20; i++) {
	    	  cal.set(2014,5,1+i);//设置日期，此时的日期是2013年11月30号
	    	  cal2.set(2014,5,1+i);
	    	  cal2.add(Calendar.DATE, 20);
	    	Advert b = new Advert(i,"user",new Date(cal.getTimeInMillis()),new Date(cal2.getTimeInMillis()),30,days,1);
	    	service.saveAdvert(b);
		}
		
	//	cal.setTime(new Date());
		
		System.out.println(cal.getTime());
		
	}

}
