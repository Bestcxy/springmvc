package com.bestcxx.stu.springmvc.common.test;

import org.junit.Test;

public class StaticTest {
	
	public static void main(String[] args) {
		new Threada().start();
		new Threadb().start();
	}

}
class Threada extends Thread{

	@Override
	public void run() {
		System.out.println("a="+StaticClass.a);
		StaticClass.a="a 还是 a";
		System.out.println("a="+StaticClass.a);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("a="+StaticClass.a);
		
	}
	
}

class Threadb extends Thread{

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("b="+StaticClass.a);
		try {
			Thread.currentThread().sleep(1000);
			System.out.println("线程b进行修改");
			StaticClass.a="b还是b";
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}