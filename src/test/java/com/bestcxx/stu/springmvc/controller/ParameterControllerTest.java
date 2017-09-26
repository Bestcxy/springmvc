package com.bestcxx.stu.springmvc.controller;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@DirtiesContext  
@WebAppConfiguration//单元测试的时候真实的开启一个web服务    
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:spring/springmvc-servlet.xml"})  
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)//事务管理    
@Rollback(true)  
public class ParameterControllerTest extends AbstractTransactionalJUnit4SpringContextTests{  
    @Autowired  
    private WebApplicationContext wac;  
    private MockMvc mockMvc;  
    @Before  
    public void setup() {  
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();   //构造MockMvc  
    }  
      
    @Test  
    public void testModel() throws Exception{  
         MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/parameterController/model"))
                 .andExpect(MockMvcResultMatchers.status().is(MockHttpServletResponse.SC_OK))  
                 .andDo(MockMvcResultHandlers.print())  
                 .andReturn();    
             
         
    }  
}  
