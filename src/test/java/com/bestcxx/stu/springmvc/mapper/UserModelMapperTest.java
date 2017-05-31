package com.bestcxx.stu.springmvc.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
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
	
	private static String resource = "mybatis/mybatis-config.xml";
	private static InputStream inputStream;
	private static SqlSessionFactory sqlSessionFactory = null;
	private static SqlSession sqlSession = null;
	
	@BeforeClass
	public static void beforeClass(){
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddUserModel(){
		if(sqlSessionFactory!=null){
			try {
				sqlSession = sqlSessionFactory.openSession();
				//some code
				UserModelMapper userModelMapper=(UserModelMapper) sqlSession.getMapper(UserModelMapper.class);
				
				UserModel u=new UserModel();
//				u.setUserName("3");//userName使用数据库自动生成
				u.setPassWord("3");
				u.setCreateDate(new Date());
				
				userModelMapper.addUserModel(u);
				
				sqlSession.commit();
				System.out.println("自动生成的主键为="+u.getUserName());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				sqlSession.rollback();
			}
		}
	}
	
	/**
	 * 测试搜索功能
	 */
	@Test
	public void testGetUserModel() {
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
			}
		}
	}
	
	
	
	@AfterClass
	public static void afterClass(){
		if(sqlSession!=null){
			sqlSession.close();
		}
	}
}
