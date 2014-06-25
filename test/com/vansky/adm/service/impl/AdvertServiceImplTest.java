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
		Advert a = new Advert(1,"admin",new Date(),new Date(),90,90,1);
		Calendar cal = Calendar.getInstance();
		
	    cal.set(2013,10,30);//设置日期，此时的日期是2013年11月30号
	    
		Advert b = new Advert(2,"user",new Date(cal.getTimeInMillis()),new Date(),30,30,1);
		service.saveAdvert(b);
	}

}
