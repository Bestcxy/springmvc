package com.bestcxx.stu.springmvc.serviceimpl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bestcxx.stu.springmvc.mapper.UserModelMapper;
import com.bestcxx.stu.springmvc.model.UserModel;
import com.bestcxx.stu.springmvc.service.UserModelService;

@Service
public class UserModelServiceImpl implements UserModelService {

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
	@Override
	public ArrayList<UserModel> getUserModelListByStrs(String userNames) {
		ArrayList<UserModel> list=userModelMapper.getUserModelListByStrs(userNames);
		if(list.size()!=0){//搜索结果不为null,应该使用size判断
			return list;
		}
		return null;
	}
	
	
	
	

}
