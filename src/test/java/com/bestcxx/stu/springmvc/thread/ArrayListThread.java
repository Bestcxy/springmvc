package com.bestcxx.stu.springmvc.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
//ArrayList对象 线程安全的三种方式
//ArrayList 是线程不安全的
//Vector 是线程安全的，内部方法是用 synchronized 修饰
//collection.synchronizedList 是线程安全的
public class ArrayListThread{
	static ArrayList<Integer> list=new ArrayList<Integer>();
	static Vector<Integer> vector=new Vector<Integer>();
	static List<Integer> li=Collections.synchronizedList(new ArrayList<Integer>());
	
	public static class ThreadOne implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<10000;i++){
				list.add(i);
			}
		}
	}
	
	public static class ThreadTwo implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<10000;i++){
				synchronized(list){
					list.add(i);							
				}
			}
		}
	}
	
	public static class ThreadThree implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<10000;i++){
				vector.add(i);
			}
		}
	}
	
	public static class ThreadFour implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<10000;i++){
				li.add(i);
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		//collections.synchronizedList-线程安全
		ThreadFour threadFour=new ThreadFour();
		Thread tfour0=new Thread(threadFour);
		Thread tfour1=new Thread(threadFour);
		
		tfour0.start();
		tfour1.start();
		
		try {
			tfour0.join();
			tfour1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(li.size());
		//collections.synchronizedList-线程安全
		
		
		
		//vector-线程安全
		/*ThreadThree threadThree=new ThreadThree();
		Thread tthree0=new Thread(threadThree);
		Thread tthree1=new Thread(threadThree);
		
		tthree0.start();
		tthree1.start();
		
		try {
			tthree0.join();
			tthree1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(vector.size());*/
		//vector-线程安全
		
		
		//synchronized 修饰 list 对象  -线程安全
		/*ThreadTwo threadTwo=new ThreadTwo();
		Thread ttwo0=new Thread(threadTwo);
		Thread ttwo1=new Thread(threadTwo);
		
		ttwo0.start();
		ttwo1.start();
		
		try {
			ttwo0.join();
			ttwo1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.size());*/
		//synchronized 修饰 list 对象  -线程安全
		
		//无保护的 ArrayList-线程不安全
		/*ThreadOne threadOne=new ThreadOne();
		Thread tone0=new Thread(threadOne);
		Thread tone1=new Thread(threadOne);
		
		tone0.start();
		tone1.start();
		
		try {
			tone0.join();
			tone1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.size());*/
		//无保护的 ArrayList-线程不安全
	}
	

}
