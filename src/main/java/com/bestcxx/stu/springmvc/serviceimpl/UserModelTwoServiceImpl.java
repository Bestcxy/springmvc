package com.bestcxx.stu.springmvc.serviceimpl;

import org.springframework.stereotype.Service;

import com.bestcxx.stu.springmvc.mapper.UserModelTwoMapper;
import com.bestcxx.stu.springmvc.model.UserModel;
import com.bestcxx.stu.springmvc.model.UserModelTwo;
import com.bestcxx.stu.springmvc.service.UserModelTwoService;
import com.bestcxx.stu.springmvc.service.base.BaseService;

@Service
public class UserModelTwoServiceImpl extends BaseService implements UserModelTwoService{

	
	@Override
	public UserModelTwo getUserModel(String userName) {
		UserModelTwoMapper userModelTwoMappe=sqlSession.getMapper(UserModelTwoMapper.class);
		return userModelTwoMappe.getUserModel(userName);
	}

	@Override
	public int addUserModel(UserModelTwo userModelTwo) {
		UserModelTwoMapper userModelTwoMappe=sqlSession.getMapper(UserModelTwoMapper.class);
		return userModelTwoMappe.addUserModel(userModelTwo);
	}

}
