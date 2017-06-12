package com.bestcxx.stu.springmvc.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bestcxx.stu.springmvc.mapper.UserModelMapper;
import com.bestcxx.stu.springmvc.model.UserModel;
import com.bestcxx.stu.springmvc.service.UserModelService;

@Service
public class UserServiceImpl implements UserModelService {

	@Resource
	private UserModelMapper userModelMapper;
	@Override
	public UserModel getUserModel(String userName) {
		UserModel u=userModelMapper.getUserModel(userName);
		return u;
	}
	@Override
	public int addUserModel(UserModel userModel) {
		return userModelMapper.addUserModel(userModel);
	}
	
	

}
