package com.bestcxx.stu.springmvc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//只有一个线程的线程池 NewSingleThreadExcecutor 先进先出的顺序先进先出
public class NewSingleThreadExcecutorTest {
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
			System.out.println(System.currentTimeMillis()+" ThreadName:"+Thread.currentThread().getName()+"结束\n");
			
		}	
	}
	
	public static void main(String[] args) {
		ExecutorService es=Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
			es.execute(new ThreadTest());			
		}
		
		System.out.println(System.currentTimeMillis()+"关闭线程池");
		es.shutdown();
		
	}
}
