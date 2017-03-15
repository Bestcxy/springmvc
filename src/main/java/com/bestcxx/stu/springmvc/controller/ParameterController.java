package com.bestcxx.stu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bestcxx.stu.springmvc.model.UserModel;
import com.bestcxx.stu.springmvc.service.UserService;

@Controller
@RequestMapping("/parameterController")
public class ParameterController {
	@Autowired
	private UserService userService;
	
	/**
	 * 测试名称 ： get方法传递参数到后台，再返回前台展示
	 * 测试路径： http://localhost:8085/springmvc/parameterController/param
	 * @param userName
	 * @return
	 */
	@RequestMapping(value="/param",method={RequestMethod.GET,RequestMethod.POST})
	public String getParameterControllerParam(@RequestParam String userName,HttpServletRequest request){
		
		//获取前台传递的参数
		System.out.println("userName="+userName);
		//获取前台传递的参数
		System.out.println(request.getParameter("userName"));
		//将参数送往前台
		request.setAttribute("userName", request.getParameter("userName"));
		return "show";
	}
	
	@RequestMapping(value="/mav",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getParameterControllerMav(@RequestParam String userName){
		ModelAndView mdv=new ModelAndView();
		mdv.setViewName("show");
		mdv.addObject("userName",userName );
		return mdv;
	}
	@RequestMapping(value="/usermodel",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public UserModel getParameterControllerUserModel(){
		UserModel u=userService.getAnyUserModel();
		return u;
	}
}
