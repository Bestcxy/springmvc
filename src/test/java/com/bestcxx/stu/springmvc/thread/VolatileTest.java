package com.bestcxx.stu.springmvc.thread;

/**
 * volatile 修饰的变量，无法确保并发修改的安全性
 * @author WuJieJecket
 *
 */
public class VolatileTest {
	public static int a=0;
	public volatile static int b=0;
	public volatile static int c=0;
	
	public static void main(String[] args) {
		Thread t1=new ThreadOne();
		Thread t2=new ThreadTwo();
		
		Thread t3=new ThreadThree();
		Thread t4=new ThreadFour();
		
		t1.start();
		t2.start();
		
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("a="+a);//a<20000
		System.out.println("b="+b);//a<b<20000
		System.out.println("c="+c);//c=20000
	}

	public static class ThreadOne extends Thread{

		@Override
		public void run() {
			for(int i=0;i<10000;i++){
				a++;
				b++;
			}
		}
		
	}
	
	public static class ThreadTwo extends Thread{

		@Override
		public void run() {
			for(int i=0;i<10000;i++){
				a++;
				b++;
			}
		}
		
	}
	
	public static class ThreadThree extends Thread{

		@Override
		public void run() {
			synchronized(this){
				for(int i=0;i<10000;i++){
					c++;
				}
			}
			
		}
		
	}
	
	public static class ThreadFour extends Thread{

		@Override
		public void run() {
			synchronized(this){
				for(int i=0;i<10000;i++){
					c++;
				}
			}
		}
		
	}
	
}
