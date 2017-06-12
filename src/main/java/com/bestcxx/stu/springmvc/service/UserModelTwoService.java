package com.bestcxx.stu.springmvc.service;

import com.bestcxx.stu.springmvc.model.UserModelTwo;

public interface UserModelTwoService {
	
	/**
	 * 根据userName（主键）获取一个实体
	 * @return
	 */
	public UserModelTwo getUserModel(String userName);
	
	/**
	 * 新增一个实体类，主键自动生成
	 * @param userModel
	 * @return
	 */
	public int addUserModel(UserModelTwo userModelTwo);

}
