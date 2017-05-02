package com.bestcxx.stu.springmvc.mapper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.bestcxx.stu.springmvc.mapper.UserModelMapper;
import com.bestcxx.stu.springmvc.model.UserModel;

/**
 * 
 * @theme 使用配置文件加载mybatis
 * @author wujie
 * @Datetime 2017年5月2日
 */
public class UserModelMapperTest {
	
	@Test
	public void testGetUserModel() {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(sqlSessionFactory!=null){
			
			try {
				sqlSession = sqlSessionFactory.openSession();
				//some code
				UserModelMapper userModelMapper=(UserModelMapper) sqlSession.getMapper(UserModelMapper.class);
				
				UserModel u=userModelMapper.getUserModel("1");
				
				System.out.println("userName="+u.getUserName());
				System.out.println("passWord="+u.getPassWord());
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				sqlSession.rollback();
			}finally {
				if(sqlSession!=null){
					sqlSession.close();
				}
			}
		}
	}
}
