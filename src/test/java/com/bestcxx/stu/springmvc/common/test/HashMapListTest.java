package com.bestcxx.stu.springmvc.common.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 遍历List中map赋值并不能改变list的状态
 * @author Administrator
 *
 */
public class HashMapListTest {
	
	@Test
	public void test1(){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list2=new ArrayList<Map<String,Object>>();
		for(int i=0;i<3;i++){
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("name", "name"+i);
			System.out.println(map.get("name"));
			list2.add(map);
		}
		
		for(Map<String,Object> map:list){
			System.out.println("2"+map.get("name"));
		}
		for(Map<String,Object> map:list2){
			System.out.println("3"+map.get("name"));
		}
		System.out.println("运行结束");
	}

}
