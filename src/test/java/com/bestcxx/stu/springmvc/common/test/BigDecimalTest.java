package com.bestcxx.stu.springmvc.common.test;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalTest {
	//BigDecimal 实现加法的两种方式
	@Test
	public void test1(){
		float a1=1.1f;
		float a2=1.2f;
		BigDecimal c=new BigDecimal(a1+a2);
		
		System.out.println(c.subtract(new BigDecimal(0.1)));
		
		BigDecimal a=new BigDecimal(a1+a2).subtract(new BigDecimal(0.1));
		System.out.println(a);
	}
	//BigDecimal实现比较大小
	@Test
	public void test2(){
		BigDecimal a1=new BigDecimal("1.1");
		BigDecimal a2=new BigDecimal("1.2");
		System.out.println(a1.compareTo(a2));//-1 为小于，0为等于，1为大于
	}

}
