package com.bestcxx.stu.springmvc.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
	
	@Test
	public void testGetUserModelListByStrs(){
		if(sqlSessionFactory!=null){
			try {
				sqlSession = sqlSessionFactory.openSession();
				//some code
				UserModelMapper userModelMapper=(UserModelMapper) sqlSession.getMapper(UserModelMapper.class);
				
				ArrayList<UserModel> list=userModelMapper.getUserModelListByStrs("2,3,4");
				
				for(UserModel u:list){
					System.out.print(u.getUserName()+"; ");
					System.out.print(u.getPassWord()+"; ");
					System.out.println(u.getCreateDate());
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				sqlSession.rollback();
			}
		}
	}
	
	@Test
	public void testGetHashMapListByList(){
		if(sqlSessionFactory!=null){
			try {
				sqlSession = sqlSessionFactory.openSession();
				//some code
				UserModelMapper userModelMapper=(UserModelMapper) sqlSession.getMapper(UserModelMapper.class);
				ArrayList<String> list=new ArrayList<String>();
				
				list.add("2");
				list.add("3");
				list.add("4");
				
				ArrayList<HashMap<String,Object>> mapList=userModelMapper.getHashMapListByList(list);
				
				for(HashMap<String, Object> m:mapList){
					if(m.get("passWord")!=null){
						System.out.print(m.get("userName").toString()+";");
						System.out.print(m.get("passWord").toString()+";");
						System.out.println(m.get("createDate").toString());
					}
					
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				sqlSession.rollback();
			}
		}
	}
	
	@Test
	public void testUpdate(){
		if(sqlSessionFactory!=null){
			try {
				sqlSession = sqlSessionFactory.openSession();
				//some code
				UserModelMapper userModelMapper=(UserModelMapper) sqlSession.getMapper(UserModelMapper.class);
				//先查
				UserModel u=userModelMapper.getUserModel("106");
				
				System.out.println("查出来的：passWord="+u.getPassWord());
				if(u!=null){
					u.setPassWord("change");
					u.setCreateDate(new Date());
					
				}
				userModelMapper.update(u);
				sqlSession.commit();
				System.out.println("修改后的：passWord="+u.getPassWord());
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				sqlSession.rollback();
			}
		}
	
	}
	
	//使用for循环测试两次-实验是，第一次新加，第二次更新，然后再新加，看是否报错，前提是知道要新加的id值
	@Test
	public void forTwo(){
		
		if(sqlSessionFactory!=null){
			try {
				sqlSession = sqlSessionFactory.openSession();
				//some code
				UserModelMapper userModelMapper=(UserModelMapper) sqlSession.getMapper(UserModelMapper.class);
				//先查
				UserModel u=userModelMapper.getUserModel("106");
				
				System.out.println("查出来的：passWord="+u.getPassWord());
				if(u!=null){
					u.setPassWord("change");
					u.setCreateDate(new Date());
					
				}
				userModelMapper.update(u);
				sqlSession.commit();
				System.out.println("修改后的：passWord="+u.getPassWord());
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				sqlSession.rollback();
			}
		}
		
		
		
	}
	
	//检测数据库是否存在 userName=106 的数据
	@Test
	public boolean check(){
		if(sqlSessionFactory!=null){
			try {
				sqlSession = sqlSessionFactory.openSession();
				//some code
				UserModelMapper userModelMapper=(UserModelMapper) sqlSession.getMapper(UserModelMapper.class);
				//先查
				UserModel u=userModelMapper.getUserModel("106");
				if(u!=null){
					return true;
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				sqlSession.rollback();
			}
		}
		return false;
		
	}
	
	@AfterClass
	public static void afterClass(){
		if(sqlSession!=null){
			sqlSession.close();
		}
	}
}
