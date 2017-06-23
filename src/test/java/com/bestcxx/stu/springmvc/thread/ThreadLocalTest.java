package com.bestcxx.stu.springmvc.thread;

public class ThreadLocalTest {
	//通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
		public Integer initialValue(){
			return 0;
			}
		};
		
	//获取下一个序列值
	public int getNextNum(){
		seqNum.set(seqNum.get()+1);
		return seqNum.get();
	}
	
	//main 方法
	public static void main(String[] args) {
		ThreadLocalTest threadLocalTest=new ThreadLocalTest();
		Thread t0=new Thread(new Threadtestt(threadLocalTest),"子线程0");
		Thread t1=new Thread(new Threadtestt(threadLocalTest),"子线程1");
		Thread t2=new Thread(new Threadtestt(threadLocalTest),"子线程2");
		
		t0.start();
		t1.start();
		t2.start();
	}
}
class Threadtestt implements Runnable{
	ThreadLocalTest threadLocalTest;
	public Threadtestt(ThreadLocalTest threadLocalTest){
		this.threadLocalTest=threadLocalTest;
	}
	@Override
	public void run() {
		for(int i=0;i<3;i++){
			System.out.println(Thread.currentThread().getName()+" "+threadLocalTest.getNextNum());			
		}
	}
	
}