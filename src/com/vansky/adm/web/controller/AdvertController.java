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

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getAdvertList() {
		System.out.println("getAssetList");
		return "index";
	}
	
	@RequestMapping(value = "/getAdvertById", method = RequestMethod.GET)
	public String getAdvertById(Model model, HttpServletRequest request) {
		System.out.println("get");
		String id =  request.getParameter("advertId");
		if(id == null || id.equals(""))return "ERROR";
		advert = advertService.getAdvertById(Integer.parseInt(id));
		model.addAttribute("advert", advert);
		return "index";
	}
	
	@RequestMapping(value = "/getAdvertList", method = RequestMethod.GET)
	public String getAdvertList(Model model, HttpServletRequest request) {
		List<Advert>  advertList= advertService.getAdvertList();
		model.addAttribute("advertList", advertList);
		return "index";
	}
	
	@RequestMapping(value = "/suspendAd", method = RequestMethod.GET)
	public String suspendAdById(Model model, HttpServletRequest request) {
		String id =  request.getParameter("advertId");
		if(id == null || id.equals(""))return "ERROR";
		advertService.suspendAdById(Integer.parseInt(id));
		
		
		return "redirect:/getAdvertList.lol";
	}
	
	@RequestMapping(value = "/resumeAd", method = RequestMethod.GET)
	public String resumeAdById(Model model, HttpServletRequest request) {
		String id =  request.getParameter("advertId");
		if(id == null || id.equals(""))return "ERROR";
		advertService.resumeAdById(Integer.parseInt(id));
		
		
		return "redirect:/getAdvertList.lol";
	}

}
