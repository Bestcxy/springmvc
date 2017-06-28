package com.bestcxx.stu.springmvc.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//newSingleThreadScheduledExecutor 可使用 execute,也可使用schedule()，用以在延时固定的时间之后运行
public class NewScheduledThreadPoolTest {
	static class ThreadTest implements Runnable{

		@Override
		public void run() {
			System.out.println(System.currentTimeMillis()+" ThreadName:"+Thread.currentThread().getName()+"开始");
		}	
	}
	
	public static void main(String[] args) {
		
		ScheduledExecutorService ses=Executors.newSingleThreadScheduledExecutor();
		for(int i=0;i<4;i++){
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
