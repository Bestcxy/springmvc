package com.bestcxx.stu.springmvc.thread;

import com.bestcxx.stu.springmvc.model.UserModel;

//并发同步的情况下
//Object wait 本线程阻塞，同级线程开始运行，notify 本线程结束，被阻塞的开始运行
//wait 阻塞时，本线程和其余线程无差异,调用wait的线程在再次获得临界区上并没有特殊权重
//wait不会使本线程退出，notify不会使本线程立即退出，前者等待其他线程调用 notify 释放临界区后继续运行（在阻塞线程中等待），后者则在剩余代码运行结束后才正式释放临界区并结束线程
public class WaitNotifyTest {
	private static UserModel userModel=new UserModel();
	public static void main(String[] args) {
		Thread t0=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(userModel){
					userModel.setIntNum(1);
					System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+"开始运行 intNum="+userModel.getIntNum());
					try {
						System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+"开始等待 intNum="+userModel.getIntNum());
						
						userModel.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+"再次运行结束 intNum="+userModel.getIntNum());
					
				}
			}
			
		},"子线程0");
		
		Thread t1=new Thread(new Runnable(){

			@Override
			public void run() {
				synchronized(userModel){
					System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+"开始运行 intNum="+userModel.getIntNum());
					userModel.setIntNum(2);
					System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+"运行结束 intNum="+userModel.getIntNum());
					userModel.notify();
					System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+"notify后继续运行结束 intNum="+userModel.getIntNum());
					
				}
				
			}
			
		},"子线程1");
		
		Thread t2=new Thread(new Runnable(){

			@Override
			public void run() {
				synchronized(userModel){
					System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+"开始运行 intNum="+userModel.getIntNum());
					userModel.setIntNum(3);
					System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+"运行结束 intNum="+userModel.getIntNum());
					userModel.notify();
					System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+"notify后继续运行结束 intNum="+userModel.getIntNum());
					
				}
				
			}
			
		},"子线程2");
		
		t0.start();
		t1.start();
		//t2.start();-放开此代码可以发现，调用wait的线程在再次获得临界区上并没有特殊权重
	}
	
	
	
	
}

