package com.bestcxx.stu.springmvc.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//本实验有风险,cpu会迅速飙升到100%,jdk 8 中不存在这个问题了
//两个线程同时遍历hashMap,破坏了hashMap的结构,可能造成链表成环，死循环
//可以用concurrentHashMap 代替 hashMap
//可以使用synchronized 修饰 hashMap 的操作方法，也是线程安全的
//Collections.synchronizedMap(new HashMap<String,String>()) 线程安全

//hashtable 是线程安全的 ，value不可为null
public class HashMapThread {
	
	public static HashMap<String,String> hashMap=new HashMap<String,String>();
	public static Map<String,String> concurrentHashMap=new ConcurrentHashMap<String,String>();
	public static Map<String,String> connectionsMap=Collections.synchronizedMap(new HashMap<String,String>());
	public static Map<String,String> hashtable=new Hashtable<String,String>();
	
	
	public static void main(String[] args) {
		
		//hashtable 线程安全
		Thread t8=new Thread(new ThreadFive(0));
		Thread t9=new Thread(new ThreadFive(1));
		
		t8.start();
		t9.start();
		
		try {
			t8.join();
			t9.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("size="+hashtable.size());
		//hashtable 线程安全
	
		
		
		//Collections.synchronizedMap 线程安全
		/*Thread t6=new Thread(new ThreadFour(0));
		Thread t7=new Thread(new ThreadFour(1));
		
		t6.start();
		t7.start();
		
		try {
			t6.join();
			t7.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("size="+connectionsMap.size());*/
		//Collections.synchronizedMap 线程安全
		
		//concurrentHashMap 线程安全
		/*Thread t4=new Thread(new ThreadThree(0));
		Thread t5=new Thread(new ThreadThree(1));
		
		t4.start();
		t5.start();
		
		try {
			t4.join();
			t5.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("size="+concurrentHashMap.size());*/
		//concurrentHashMap 线程安全
		
		
		//synchronized 修饰 HashMap 线程安全
		/*Thread t2=new Thread(new ThreadTwo(0));
		Thread t3=new Thread(new ThreadTwo(1));
		
		t2.start();
		t3.start();
		
		try {
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("size="+hashMap.size());*/
		//synchronized 修饰 HashMap 线程安全
		
		
		//HashMap 线程不安全，会造成死循环
		/*Thread t0=new Thread(new ThreadOne(0));
		Thread t1=new Thread(new ThreadOne(1));
		
		t0.start();
		t1.start();
		
		try {
			t0.join();
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("size="+hashMap.size());*/
		//HashMap 线程不安全，会造成死循环
		
	}
	
	public static class ThreadOne implements Runnable{
		int i=0;
		public ThreadOne() {}
		
		public ThreadOne(int i) {
			this.i=i;
		}
		@Override
		public void run() {
			for(int j=i;j<10000;j+=2){
				hashMap.put(Integer.toString(j), Integer.toBinaryString(j));
			}
			
		}
		
	}
	
	public static class ThreadTwo implements Runnable{
		int i=0;
		public ThreadTwo() {}
		
		public ThreadTwo(int i) {
			this.i=i;
		}
		@Override
		public void run() {
			int j=i;
			for(;j<10000;j++){
				synchronized(hashMap){
					hashMap.put(Integer.toString(j), Integer.toBinaryString(j));					
				}
			}
			System.out.println("j="+j);
			
		}
		
	}
	
	public static class ThreadThree implements Runnable{
		int i=0;
		public ThreadThree() {}
		
		public ThreadThree(int i) {
			this.i=i;
		}
		@Override
		public void run() {
			for(int j=i;j<10000;j+=2){
				concurrentHashMap.put(Integer.toString(j), Integer.toBinaryString(j));
			}
			
		}
		
	}
	
	public static class ThreadFour implements Runnable{
		int i=0;
		public ThreadFour() {}
		
		public ThreadFour(int i) {
			this.i=i;
		}
		@Override
		public void run() {
			for(int j=i;j<10000;j+=2){
				connectionsMap.put(Integer.toString(j), Integer.toBinaryString(j));
			}
			
		}
		
	}
	
	public static class ThreadFive implements Runnable{
		int i=0;
		public ThreadFive() {}
		
		public ThreadFive(int i) {
			this.i=i;
		}
		@Override
		public void run() {
			for(int j=i;j<10000;j+=2){
				hashtable.put(Integer.toString(j), Integer.toBinaryString(j));
			}
			
		}
		
	}

}
