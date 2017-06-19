package com.bestcxx.stu.springmvc.thread;

import org.junit.Test;

/**
 * 多编程测试
 * @theme 
 * @author wujie
 * @Datetime 2017年6月19日
 */
public class ThreadCommonTest {
	
	/**
	 * 通过重写 Thread 的匿名内部类调用线程
	 * @instruction
	 * @Datetime 2017年6月19日 上午10:24:04
	 */
	@Test
	public void testThread(){
		for(int i=0;i<5;i++){
			Thread t0=new Thread(){
				@Override
				public void run() {
					System.out.println("内部实现类实现线程");
				}
				
			};
			
			t0.start();
		}
		
	}
	
	/**
	 * Thread 结构方法 传入 Runnable 实现
	 * @instruction
	 * @Datetime 2017年6月19日 上午11:54:59
	 */
	@Test
	public void testRunnable(){
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("Thread(Runnable target)实现线程");
			}
		}).start();;
	}
}
