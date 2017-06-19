package com.bestcxx.stu.springmvc.thread;

/**
 * 继承 Thread 类的多线程类
 * @theme 
 * @author wujie
 * @Datetime 2017年6月19日
 */
public class ThreadExtendsThread extends Thread {
	@Override
	public void run() {
		System.out.println("继承 Thread 类的线程,getName:"+Thread.currentThread().getName()+",Thread id:"+Thread.currentThread().getId());
	}
}
