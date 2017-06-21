package com.bestcxx.stu.springmvc.common.test;

import org.junit.Test;
/**
 *  对于某个类被public static 修饰的变量，多个线程之间会共享这个变量，不管这个类被实例化多少次，这个变量都只会初始化一次，之后要看是否有线程对其进行修改。
 * @author WuJieJecket
 *
 */
public class StaticTest {
	
	public static void main(String[] args) {
		new Threada().start();
		new Threadb().start();
	}

}
class Threada extends Thread{

	@Override
	public void run() {
		
		StaticClass a=new StaticClass();
		
		/*System.out.println("a="+StaticClass.a);
		StaticClass.a="a 还是 a";
		System.out.println("a="+StaticClass.a);*/
		System.out.println("a="+a.a);
		StaticClass.a="a 还是 a";
		System.out.println("a="+a.a);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("a="+StaticClass.a);
		System.out.println("a="+a.a);
		
	}
	
}

class Threadb extends Thread{

	@Override
	public void run() {
		StaticClass b=new StaticClass();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("b="+StaticClass.a);
		System.out.println("b="+b.a);
		try {
			Thread.currentThread().sleep(1000);
			System.out.println("线程b进行修改");
			//StaticClass.a="b还是b";
			b.a="b还是b";
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}