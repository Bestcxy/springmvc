package com.bestcxx.stu.springmvc.service;

import java.util.ArrayList;

import com.bestcxx.stu.springmvc.model.UserModel;

public interface UserModelService {
	
	/**
	 * 根据userName（主键）获取一个实体
	 * @return
	 */
	public UserModel getUserModel(String userName);
	
	/**
	 * 新增一个实体类，主键自动生成
	 * @param userModel
	 * @return
	 */
	public int addUserModel(UserModel userModel);
	
	/**
	 * 查询集群
	 * @instruction
	 * @Datetime 2017年6月28日 下午3:42:08
	 * @param userNames
	 * @return
	 */
	public ArrayList<UserModel> getUserModelListByStrs(String userNames);

}
