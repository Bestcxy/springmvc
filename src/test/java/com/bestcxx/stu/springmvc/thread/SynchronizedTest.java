package com.bestcxx.stu.springmvc.thread;

//synchronized(Object) 方法实验
//对于多线程操作同一个临界区时，被synchronized修饰的类不可被多个线程同时操作
//synchronized 可以修饰方法，或者变量，也可以在多线程调用中设定
//使用 static 就是全局性的，否则只对当前对象有作用，别忘了 new Thread(Target) 的构造方法 
public class SynchronizedTest {
volatile static int num;

	//静态 同步方法，注意这里的参数是全局的
	public static synchronized void method(){
		for(int i=0;i<10;i++){
			System.out.println(System.currentTimeMillis()+" 名字："+Thread.currentThread().getName()+" "+SynchronizedTest.num++);
		}
	}

	public static void main(String[] args) {
		/***********************线程中加同步设置*******************************/
		/*Thread t0=new Thread(new ThreadTest(),"子线程0");
		Thread t1=new Thread(new ThreadTest(),"子线程1");
		t0.start();
		t1.start();*/
		/******************************************************/
		
		/***********************被调用的方法中加同步设置*******************************/
		Thread t2=new Thread(new ThreadTest2(),"子线程2");
		Thread t3=new Thread(new ThreadTest2(),"子线程3");
		t2.start();
		t3.start();
		/******************************************************/
		
	}

}
class ThreadTest implements Runnable{

	@Override
	public void run() {
		synchronized(SynchronizedTest.class){
			for(int i=0;i<10;i++){
				System.out.println(System.currentTimeMillis()+" 名字："+Thread.currentThread().getName()+" "+SynchronizedTest.num++);
			}
		}
	}
	
}	
		
class ThreadTest2 implements Runnable{

	@Override
	public void run() {
		new SynchronizedTest().method();
	}
}

