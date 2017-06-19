package com.bestcxx.stu.springmvc.thread;

import org.junit.Test;

public class ThreadImplementsRunnableTest {
	
	@Test
	public void test0(){
		for(int i=0;i<10;i++){
			//需要先实例化ThreadImplementsRunnable
			//再实例化Thread，使用 Thread 的构造方法把 ThreadImplementsRunnable 传递进去
			ThreadImplementsRunnable t0=new ThreadImplementsRunnable();
			Thread t1=new Thread(t0);//new Thread(t0,"ThreadName")
			t1.start();
		}
		
	}

}
