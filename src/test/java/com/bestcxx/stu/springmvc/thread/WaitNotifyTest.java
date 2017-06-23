package com.bestcxx.stu.springmvc.thread;

import com.bestcxx.stu.springmvc.model.UserModel;

//并发同步的情况下
//Object wait 本线程阻塞，同级线程开始运行，notify 本线程结束，被阻塞的开始运行
//wait 阻塞时，本线程和其余线程无差异
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
		t2.start();
	}
	
	
	
	
}

