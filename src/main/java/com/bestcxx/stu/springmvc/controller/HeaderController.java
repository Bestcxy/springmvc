package com.bestcxx.stu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/header")
public class HeaderController {
	
	@RequestMapping(value="/get/auto_token",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
	public ModelAndView getHeader(@RequestHeader HttpHeaders headers,HttpServletRequest request){
		
		ModelAndView mdv=new ModelAndView();
		mdv.setViewName("header");
		mdv.addObject("headerFrom",headers.getFirst("Accept-Encoding"));//获取header的内容
		String requestURI=request.getRequestURI();
		mdv.addObject("requestFrom",requestURI.substring(requestURI.indexOf("/", 2), requestURI.length()));//获取路径  /header/get/auto_token
		return mdv;
	}
}
