package com.bestcxx.stu.springmvc.common.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class ArrayListTest {
	@Test
	public void test(){
		ArrayList list=new ArrayList();
		HashMap<String ,Object> map=new HashMap<String ,Object>();
		map.put(null, "123");
		System.out.println(map.get("123"));
		Object o=new Object();
		o.toString();
		o.hashCode();
	}

}
