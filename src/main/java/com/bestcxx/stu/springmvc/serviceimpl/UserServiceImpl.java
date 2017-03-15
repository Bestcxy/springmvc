package com.bestcxx.stu.springmvc.serviceimpl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.bestcxx.stu.springmvc.model.UserModel;
import com.bestcxx.stu.springmvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public UserModel getAnyUserModel() {
		// TODO Auto-generated method stub
		UserModel u=new UserModel();
		u.setUserName("username_tem");
		u.setPassWord("******");
		u.setCreateDate(new Date());
		return u;
	}

}
