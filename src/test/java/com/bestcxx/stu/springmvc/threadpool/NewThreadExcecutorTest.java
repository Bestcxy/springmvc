package com.bestcxx.stu.springmvc.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewThreadExcecutorTest {
	static class ThreadTest implements Runnable{

		@Override
		public void run() {
			System.out.println(System.currentTimeMillis()+" ThreadName:"+Thread.currentThread().getName()+"开始");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public static void main(String[] args) {
		
		ScheduledExecutorService ses=Executors.newScheduledThreadPool(5);
		for(int i=0;i<10;i++){
			ses.schedule(new ThreadTest(), 1000, TimeUnit.MILLISECONDS);//固定延时
			//ses.execute(new  ThreadTest());
		}
		
		System.out.println(System.currentTimeMillis()+"关闭线程池");
		ses.shutdown();
		System.out.println(System.currentTimeMillis()+" "+ses.isShutdown()+" "+ses.isTerminated());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis()+" "+ses.isShutdown()+" "+ses.isTerminated());
	}
}
