package com.bestcxx.stu.springmvc.thread;

/**
 * 守护线程测试
 * 守护线程是一种特殊的线程，比如垃圾回收线程、JIT（动态编译，Just-In-Time,http://blog.csdn.net/hsuxu/article/details/9320699）线程
 * 与守护线程对应的是用户线程，用户线程可以认为是系统的工作线程，它会完成这个程序应该要完成的业务操作。
 * 当用户线程全部运行结束，守护线程才会停止。
 * 用户线程通过 setDaemon(true) 可以手动设置守护线程
 * @author WuJieJecket
 *
 */
public class DaemonThreadTest implements Runnable{
	
		public static void main(String[] args) {
			Thread t0=new Thread(new DaemonThreadTest(),"守护线程");
			t0.setDaemon(true);//将本线程设置为守护线程
			t0.start();
			
			try {
				t0.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("运行结束 "+System.currentTimeMillis());
			
		}

	
	@Override
	public void run() {
		System.out.println("开始进入永久成立循环 "+System.currentTimeMillis());
		while(true){
			System.out.println("在运行 "+System.currentTimeMillis());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
