package com.bestcxx.stu.springmvc.trigger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TestTrigger {
	private Logger logger=LogManager.getLogger(TestTrigger.class);
	
	
	public void TheTriggerMethod(){
		logger.info("\n\n测试定时任务\n\n");
	}

}
