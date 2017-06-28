package com.bestcxx.stu.springmvc.thread;

//线程提供了优雅的中断的方法
//首先，线程1处于运行状态
//线程1.interrupt() 会对线程增加中断标志位，但是不意味着线程就会立即中断,而是需要有效的逻辑支持,interrupt 是线程中断通信的一种支持方式，线程究竟能否中断在于是否走出循环的代码片段
		//需要Thread.currentThread().isInterrupted()或者Thread.currentThread().interrupted()为true才可以
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
						System.out.println(System.currentTimeMillis()+" 设置中断指令"+Thread.currentThread().getName()+" "+i);
						
						Thread.currentThread().interrupt();//这一段是必须的，因为异常会造成中断标志位为false，循环好会继续
					}
				}
				System.out.println(System.currentTimeMillis()+" 中断指令返回true后，线程还会运行完剩余部分"+Thread.currentThread().getName()+" "+i);
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
