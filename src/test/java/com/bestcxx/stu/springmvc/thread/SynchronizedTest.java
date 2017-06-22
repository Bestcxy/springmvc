package com.bestcxx.stu.springmvc.thread;

//synchronized(Object) 方法实验
//对于多线程操作同一个临界区时，被synchronized修饰的类不可被多个线程同时操作
public class SynchronizedTest {
volatile static int num;
	
	public static void main(String[] args) {	
		Thread t0=new Thread(new ThreadTest(),"子线程0");
		Thread t1=new Thread(new ThreadTest(),"子线程2");
		t0.start();
		t1.start();
	}

}
class ThreadTest implements Runnable{

	@Override
	public void run() {
		synchronized(ReentrantLockTest.class){
			for(int i=0;i<10;i++){
				System.out.println(System.currentTimeMillis()+" 名字："+Thread.currentThread().getName()+" "+ReentrantLockTest.num++);
			}
		}
	}
		
		
}
