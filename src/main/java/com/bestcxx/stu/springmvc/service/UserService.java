package com.bestcxx.stu.springmvc.service;

import com.bestcxx.stu.springmvc.model.UserModel;

public interface UserService {
	
	/**
	 * 根据userName（主键）获取一个实体
	 * @return
	 */
	public UserModel getUserModel(String userName);

}
