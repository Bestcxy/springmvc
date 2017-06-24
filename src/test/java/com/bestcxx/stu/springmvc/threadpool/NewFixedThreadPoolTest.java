package com.bestcxx.stu.springmvc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPoolTest {
	static class ThreadTest implements Runnable{

		@Override
		public void run() {
			System.out.println(System.currentTimeMillis()+" ThreadName:"+Thread.currentThread().getName()+"开始");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
	}
	
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(5);
		for(int i=0;i<10;i++){
			es.execute(new ThreadTest());			
		}
		
		System.out.println(System.currentTimeMillis()+"关闭线程池");
		es.shutdown();
		
	}
}

