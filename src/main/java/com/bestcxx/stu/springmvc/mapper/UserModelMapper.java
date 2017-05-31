package com.bestcxx.stu.springmvc.mapper;

import org.apache.ibatis.annotations.Param;
import com.bestcxx.stu.springmvc.model.UserModel;

/**
 * @theme mybatis xml配置对应的 mapper
 * @author wujie
 * @Datetime 2017年5月2日
 */
public interface UserModelMapper {
	public UserModel getUserModel(@Param("userName") String userName);
	public int addUserModel(UserModel userModel );//如果启动 mybitas 的属性自识别功能，不要对实体进行@Param("userModel")的设置
}
