package com.vansky.adm.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vansky.adm.domain.Advert;
import com.vansky.adm.service.AdvertService;

@Controller
public class AdvertController {
	
	@Resource
	private transient AdvertService advertService;
	
	private Advert advert;

	
	@RequestMapping(value = "/getAdvertById", method = RequestMethod.GET)
	public String getAdvertById(Model model, HttpServletRequest request) {
		String id =  request.getParameter("advertId");
		if(id == null || id.equals(""))return "ERROR";
		Advert a = new Advert();
		a.setAdvertId(Integer.parseInt(id));
		advert = advertService.getAdvert(a);
		model.addAttribute("advert", advert);
		return "index";
	}
	
	@RequestMapping(value = "/getAdvertList", method = RequestMethod.GET)
	public String getAdvertList(Model model, HttpServletRequest request) {
		advertService.updateRemainedDate();
		List<Advert>  advertList= advertService.getAdvertList();
		model.addAttribute("advertList", advertList);
		return "index";
	}
	
	@RequestMapping(value = "/suspendAd", method = RequestMethod.GET)
	public String suspendAd(Model model, HttpServletRequest request) {
		String id =  request.getParameter("advertId");
		if(id == null || id.equals(""))return "ERROR";
		Advert a = new Advert();
		a.setAdvertId(Integer.parseInt(id));
		advertService.suspend(a);
		return "redirect:/getAdvertList.lol";
	}
	
	@RequestMapping(value = "/resumeAd", method = RequestMethod.GET)
	public String resumeAd(Model model, HttpServletRequest request) {
		String id =  request.getParameter("advertId");
		if(id == null || id.equals(""))return "ERROR";
		Advert a = new Advert();
		a.setAdvertId(Integer.parseInt(id));
		advertService.resume(a);	
		return "redirect:/getAdvertList.lol";
	}

}
