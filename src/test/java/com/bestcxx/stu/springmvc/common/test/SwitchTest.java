package com.bestcxx.stu.springmvc.common.test;

import org.junit.Test;
/**
 * switch 会首先输出满足条件的，在满足条件而没有break后，则会直接输出其余条件代码，而不做判断，所以break是必须的
 */
public class SwitchTest {
	
	/**
	 * switch 会首先输出满足条件的，在满足条件而没有break后，则会直接输出其余条件代码，而不做判断，所以break是必须的
	 */
	@Test
	public void testSwitch(){
		Integer a=2;
		switch(a){
		case 1:
			System.out.println("1-输出1");
		case 2:
			System.out.println("1-输出2");
		case 3:
			System.out.println("1-输出3");
		
		}
		
		switch(a){
		case 1:
			System.out.println("2-输出1");break;
		case 2:
			System.out.println("2-输出2");break;
		case 3:
			System.out.println("2-输出3");break;
		
		}
		
	}
	
	@Test
	public void test2(){
		int num=0;
		System.out.println(num == 0 ? 0 : num - 1);
	}
	

}
