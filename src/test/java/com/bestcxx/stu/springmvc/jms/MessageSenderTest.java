package com.bestcxx.stu.springmvc.jms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/springmvc-servlet.xml"})
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)//事务管理  
@Rollback(true)
public class MessageSenderTest {
	@Autowired
    private MessageSender messageSender;

	@Test
    public void TestSendAndOnMessage() {
        messageSender.send("message");
    }
}
