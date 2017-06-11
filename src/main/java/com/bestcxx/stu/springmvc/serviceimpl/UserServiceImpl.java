package com.bestcxx.stu.springmvc.serviceimpl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.bestcxx.stu.springmvc.mapper.UserModelMapper;
import com.bestcxx.stu.springmvc.model.UserModel;
import com.bestcxx.stu.springmvc.service.UserService;
import com.bestcxx.stu.springmvc.service.base.BaseService;

@Service
public class UserServiceImpl extends BaseService implements UserService {

	private UserModelMapper userModelMapper;
	@Override
	public UserModel getAnyUserModel() {
		userModelMapper=sqlSession.getMapper(UserModelMapper.class);
		UserModel u=new UserModel();
		u.setPassWord("******");
		u.setCreateDate(new Date());
		u.setIntNum(1);
		u.setDecimalNum(new BigDecimal("0.01"));
		userModelMapper.addUserModel(u);
		
		return u;
	}

}
