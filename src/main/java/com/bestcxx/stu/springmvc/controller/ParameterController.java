package com.bestcxx.stu.springmvc.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.apache.camel.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bestcxx.stu.springmvc.common.util.EnumUtil;
import com.bestcxx.stu.springmvc.model.AjaxRespnseModel;
import com.bestcxx.stu.springmvc.model.UserModel;
import com.bestcxx.stu.springmvc.service.UserModelService;

@Controller
@RequestMapping("/parameterController")
public class ParameterController {

	@Autowired
	private UserModelService userService;
	
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
		request.setAttribute("time", "2017-12-01 11:11:11");
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
		UserModel u=userService.getUserModel("2");
		return u;
	}
	
	@RequestMapping(value="/ajaxCheckUserName",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public AjaxRespnseModel<String> getCheckUserName(@RequestParam String userName){
		
		AjaxRespnseModel<String> a=new AjaxRespnseModel<String>();
		if(StringUtils.isNotBlank(userName)){
			if("123".equals(userName)){
				//userName 已经存在，不允许提交
				a.setResult(EnumUtil.AJAX_RESPONSE_STATUS_FALSE.toString());
				a.setMsg("数据后台已经存在了");
			}else{
				//userName 尚未存在，允许提交
				a.setResult(EnumUtil.AJAX_RESPONSE_STATUS_TRUE.toString());
				a.setMsg("数据尚未存在");
			}
		}else{
			//userName 为空
			a.setResult(EnumUtil.AJAX_RESPONSE_STATUS_FALSE.toString());
			a.setMsg("提交数据不允许为空");
		}
		
		
		return a;
	}
	
	@RequestMapping(value="/model",method={RequestMethod.GET,RequestMethod.POST})
	public String model(@Valid @ModelAttribute UserModel usermodel,BindingResult bindingResult){
		System.out.println("有userName吗："+usermodel.getUserName());
		if(bindingResult.hasErrors()){
			System.out.println("校验生效了："+bindingResult.getFieldError());
		}else{
			System.out.println("不输出任何");
		}
		return "redirect:/home";
	}
}
