package com.bestcxx.stu.springmvc.thread;

public class ThreadImplementsRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("实现 Runnable 接口类的线程,getName:"+Thread.currentThread().getName()+",id:"+Thread.currentThread().getId());
	}

}
