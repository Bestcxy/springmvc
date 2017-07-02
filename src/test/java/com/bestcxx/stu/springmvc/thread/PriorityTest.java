package com.bestcxx.stu.springmvc.thread;

/**
 * 线程优先级级别高的优先运行，setPriority(int)
 * @author WuJieJecket
 *
 */
public class PriorityTest {
	
	public static void main(String[] args) {
		
		Thread highThread=new Thread(new HighPriorityThread(),"Higt Thread");
		Thread lowThread=new Thread(new LowPriorityThread(),"Low Thread");
		
		highThread.setPriority(10);
		lowThread.setPriority(1);
		
		lowThread.start();
		highThread.start();
		
	}
	
	public static class HighPriorityThread implements Runnable{
		static volatile int num=0;
		@Override
		public void run() {
			System.out.println("High Thread 启动");
			while(true){
				synchronized(PriorityTest.class){
					num++;
					if(num>10000000){
						System.out.println("High End"+" ThreadName="+Thread.currentThread().getName());
						break;
					}
				}
			}
			
			
		}
		
	}
	
	public static class LowPriorityThread implements Runnable{
		static volatile int num=0;
		@Override
		public void run() {
			System.out.println("Low Thread 启动");
			while(true){
				synchronized(PriorityTest.class){
					num++;
					if(num>10000000){
						System.out.println("Low End"+" ThreadName="+Thread.currentThread().getName());
						break;
					}
				}
			}
			
		}
		
	}
	
	

}
