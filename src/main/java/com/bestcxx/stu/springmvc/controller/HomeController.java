package com.bestcxx.stu.springmvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping({"/","home"})  
    public String shouHomePage(Map<String,String> model){  
        return "home";  
    }  
}
