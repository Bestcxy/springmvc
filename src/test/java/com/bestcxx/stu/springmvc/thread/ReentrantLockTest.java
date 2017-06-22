package com.bestcxx.stu.springmvc.thread;

import java.util.concurrent.locks.ReentrantLock;

//ReentrantLock lock 和 unlock 之间的代码，对于同一个Runnable 实例来说，是同步的
public class ReentrantLockTest implements Runnable{
	private ReentrantLock lock = new ReentrantLock(true);//true 开启公平模式
	volatile int i;
	public static void main(String[] args) {
		Runnable r=new ReentrantLockTest();
		Thread t0=new Thread(r,"子线程0");
		Thread t1=new Thread(r,"子线程1");
		Thread t2=new Thread(r,"子线程2");
		
		t0.start();
		t1.start();
		t2.start();
	}
	@Override
	public void run() {
		lock.lock();
		
		for(int i=0;i<10;i++){
			System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName());
		}	
				
		lock.unlock();
	}
	
	
}
