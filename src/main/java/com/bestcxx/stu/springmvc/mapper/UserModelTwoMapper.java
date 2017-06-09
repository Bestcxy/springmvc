package com.bestcxx.stu.springmvc.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import com.bestcxx.stu.springmvc.model.UserModel;

/**
 * @theme mybatis xml配置对应的 mapper
 * @author wujie
 * @Datetime 2017年5月2日
 */
public interface UserModelTwoMapper {
	public UserModel getUserModel(@Param("userName") String userName);//搜索返回一个实体,如果有多个则报错
	public int addUserModel(UserModel userModel );//如果启动 mybitas 的属性自识别功能，不要对实体进行@Param("userModel")的设置
	public ArrayList<UserModel> getUserModelListByStrs(@Param("userNames") String userNames);//入参为 11,22,33 形式的字符串，返回实体的list
	public ArrayList<HashMap<String,Object>> getHashMapListByList(@Param("userNamelist") ArrayList userNamelist);
	public void update(UserModel userModel);//update方法
	public int insertFromUserModel(@Param("userName") String userName);//从userName表搜索数据保存到userNameTwo表
}
