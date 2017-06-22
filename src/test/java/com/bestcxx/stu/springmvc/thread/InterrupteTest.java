package com.bestcxx.stu.springmvc.thread;

//线程提供了优雅的中断的方法
//首先，线程1处于运行状态
//线程1.interrupt() 会对线程增加中断标志位，但是不意味着线程就会立即中断
		//需要Thread.currentThread().isInterrupted()或者Thread.currentThread().interrupted()为true才可以，即必须运行这两句之一的代码
//Thread.currentThread().interrupted() 不但会执行中断线程，返回 true 或者 false，而且会消除线程1.interrupt() 的设置，即只有首次访问会返回true
//但凡是报出 InterruptedException 异常的方法都会消除中断标志，即isInterrupted()为false，所以为了防止中断失效，
		//需要在 catch 中再次增加中断设置线程1.interrupt()
public class InterrupteTest {

	public static void main(String[] args) {
		
		Thread t0=new Thread(new Runnable(){

			@Override
			public void run() {
				int i=0;
				while(!Thread.currentThread().interrupted()){
				//while(!Thread.currentThread().isInterrupted()){
				//while(true){
					System.out.println(System.currentTimeMillis()+" 没有中止指令"+Thread.currentThread().getName()+" "+i);
					i++;
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Thread.currentThread().interrupt();//这一段是必须的，因为异常会造成中断标志位为false，循环好会继续
					}
				}
			}
			
		},"子线程0");
		t0.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+" 设置中断标志");
		t0.interrupt();
		System.out.println(System.currentTimeMillis()+" 无限循环中断运行结束;"+" 线程中断标志:"+Thread.currentThread().isInterrupted());
	}

}
