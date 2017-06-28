package com.bestcxx.stu.springmvc.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
	
	private static String resource = "mybatis/mybatis-config-noSpring.xml";
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
				u.setIntNum(1);
				u.setDecimalNum(new BigDecimal("0.01"));
				
				int a=userModelMapper.addUserModel(u);
				
				sqlSession.commit();

				System.out.println("插入新数据条数="+a);
				System.out.println("自动生成的主键为="+u.getUserName());
				System.out.println("新生成的实体为="+u.toString());
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
				
				UserModel u=userModelMapper.getUserModel("758870");
				
				System.out.println("查询到的实体="+u.toString());
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
				
				ArrayList<UserModel> list=userModelMapper.getUserModelListByStrs("2,32,42");
				
				for(UserModel u:list){
					System.out.println(u.toString());
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
						
						System.out.println(m.toString());
					}
					
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				sqlSession.rollback();
			}
		}
	}
	
	@Test
	@Ignore
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
	//@Ignore
	public void forTwo(){
		
		if(sqlSessionFactory!=null){
			try {
				sqlSession = sqlSessionFactory.openSession();
				//some code
				UserModelMapper userModelMapper=(UserModelMapper) sqlSession.getMapper(UserModelMapper.class);
				//插入新数据
					
				UserModel u1=new UserModel();
				//userName使用数据库自动生成
				u1.setPassWord("dubboTest");
				u1.setCreateDate(new Date());
				
				int a=userModelMapper.addUserModel(u1);
				
				sqlSession.commit();

				System.out.println("插入新数据条数="+a);
				System.out.println("自动生成的主键为="+u1.getUserName());
				
				//再查-需要知道刚才插入的自动生成的主键即userName
				UserModel u2=userModelMapper.getUserModel(u1.getUserName());
				
				System.out.println("查出来的：passWord="+u2.getPassWord());
				if(u2!=null){
					u2.setPassWord("dubboTestchange");
					u2.setCreateDate(new Date());
					
				}
				userModelMapper.update(u2);
				sqlSession.commit();
				System.out.println("修改后的：passWord="+u2.getPassWord());
				
				//再插入
				UserModel u3=new UserModel();
				//userName使用数据库自动生成
				u3.setPassWord("dubboTest2");
				u3.setCreateDate(new Date());
				
				int bNum=userModelMapper.addUserModel(u3);
				
				sqlSession.commit();

				System.out.println("插入新数据条数="+bNum);
				System.out.println("自动生成的主键为="+u3.getUserName());
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				sqlSession.rollback();
			}
		}
	
		
	}
	
	//循环插入N万条数据，看数据库是否报错
	@Test
	public void insertFull(){
		if(sqlSessionFactory!=null){
			try {
				sqlSession = sqlSessionFactory.openSession();
				//some code
				UserModelMapper userModelMapper=(UserModelMapper) sqlSession.getMapper(UserModelMapper.class);
				UserModelTwoMapper userModelTwoMapper=(UserModelTwoMapper) sqlSession.getMapper(UserModelTwoMapper.class);
				
				String userNameStr="";
				for(int i=0;i<1;i++){
					
					//增加一个查询
					if(!"".equals(userNameStr)){
						//增加一个查询
						UserModel uS=userModelMapper.getUserModel(userNameStr);
						System.out.print("查询=="+userNameStr+"  ");
					}
					
					UserModel u=new UserModel();
//					u.setUserName("3");//userName使用数据库自动生成
					u.setPassWord("abcdefghijklmnoqrstuvwxyz");
					u.setCreateDate(new Date());
					u.setIntNum(100);
					u.setDecimalNum(new BigDecimal("0.01"));
					
					int a=userModelMapper.addUserModel(u);
					
					System.out.print("  插入新数据条数="+a);
					System.out.print("  自动生成的主键为="+u.getUserName());
					System.out.print("  自动生成的个数为="+u.getPassWord()+"\n");
					userNameStr=u.getUserName();
					
					userModelTwoMapper.insertFromUserModel(u.getUserName());
				}
				sqlSession.commit();

				
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
