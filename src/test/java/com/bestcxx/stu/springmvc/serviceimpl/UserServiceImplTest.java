package com.bestcxx.stu.springmvc.serviceimpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bestcxx.stu.springmvc.model.UserModel;
import com.bestcxx.stu.springmvc.service.UserService;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/springmvc-servlet.xml"})
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)//事务管理  
//@Rollback(false)
public class UserServiceImplTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void testGetUserModelByUserName(){
		String userName="2";
		UserModel u=userService.getUserModel(userName);
		System.out.println("查询结果为="+u.toString());
	}
}
