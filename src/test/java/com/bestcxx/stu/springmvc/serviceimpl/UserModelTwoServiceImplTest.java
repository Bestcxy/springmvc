package com.bestcxx.stu.springmvc.serviceimpl;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bestcxx.stu.springmvc.model.UserModelTwo;
import com.bestcxx.stu.springmvc.service.UserModelTwoService;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/springmvc-servlet.xml"})
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)//事务管理  
@Rollback(false)
public class UserModelTwoServiceImplTest  extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private UserModelTwoService userModelTwoService;
	
	@Test
	public void testGetUserModelByUserName(){
		String userName="2";
		UserModelTwo u=userModelTwoService.getUserModel(userName);
		System.out.println("查询结果为="+u.toString());
	}
	
	/**
	 * 新增一个实体
	 */
	@Test
	public void testAddUserModel(){
		UserModelTwo u=new UserModelTwo();
		u.setCreateDate(new Date());
		u.setDecimalNum(new BigDecimal("0.01"));
		u.setIntNum(1);
		u.setPassWord("abcdefg");
		int i=userModelTwoService.addUserModel(u);
		System.out.println(i);
		System.out.println(u.toString());
		
		
	}
	
}
