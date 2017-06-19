package com.bestcxx.stu.springmvc.thread;

import org.junit.Test;

public class ThreadExtendsThreadTest {
	
	/**
	 * 可以从输出结果感受下多线程的运行
	 * @instruction
	 * @Datetime 2017年6月19日 上午11:34:23
	 */
	@Test
	public void test0(){
		for(int i=0;i<10;i++){
			//直接实例化 线程类.start
			new ThreadExtendsThread().start();
		}
	}
}
