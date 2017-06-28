package com.bestcxx.stu.springmvc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//NewCachedThreadPool 会根据最大线程并发量设置线程池中的数目，可能会发生内存泄露的问题
//多线程中，线程池.shutdown()会下发线程池关闭命令，线程池.isShutdown会立即为true,线程池.isTerminated 会在线程池中所有任务结束之后返回true,否则为false。
//即后面二者返回true.运行shutdown命令是前提。
public class NewCachedThreadPoolTest {
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
		ExecutorService es=Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			es.execute(new ThreadTest());			
		}
		
		//System.out.println(System.currentTimeMillis()+"关闭线程池");
		//es.shutdown();
		System.out.println(System.currentTimeMillis()+" "+es.isShutdown()+" "+es.isTerminated());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis()+" "+es.isShutdown()+" "+es.isTerminated());
	}
}
