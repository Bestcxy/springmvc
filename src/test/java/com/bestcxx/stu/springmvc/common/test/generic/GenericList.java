package com.bestcxx.stu.springmvc.common.test.generic;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

/**
 * 泛型作用:
 * 泛型可以用于三种场景：
 * 1、简单的限定参数类型；
 * 2、用于类型转化的参数限定，即通配符类型上限和下限，因为在转化的时候，子类转父类是协转，是自动的，父类转子类是逆转，需要编写代码手动处理，即处理方式不同；
 * 3、结合Java的反射特性由父类获得子类的参数类型或者生成子类的实现，实现代码的集约。
 * 
 * 当子类转父类时，是自动的，当父类转子类时则需要单独处理，所以这个时候可以使用泛型进行限定
 * 这个涉及到一个概念:协变与逆变,也即上面说到的类型转化，斜边是子类转父类，逆变是父类转子类
 * @author Administrator
 *
 */
public class GenericList {
	/**
	 * 问题：
	 * ArrayList<Number> b=new  ArrayList<Number>();
	 * ArrayList<AtomicInteger> c=new  ArrayList<AtomicInteger>();
	 * 入参是 ArrayList<Number>
	 * 可以使用ArrayList<AtomicInteger>处理吗？和泛型结合呢？
	 * 答案：子类可以自动转化为父类，但是父类不能自动转化为子类
	 */

	
	Integer i;
	Number j;
	AtomicInteger m;
	
	
	@Test
	public void testAtomicIntegerToNumber(){
		ArrayList<Number> b=new  ArrayList<Number>();
		ArrayList<AtomicInteger> c=new  ArrayList<AtomicInteger>();
		ArrayList<String> d=new  ArrayList<String>();
		m=new AtomicInteger(1);
		for(int i=0;i<10;i++){
			c.add(m);
		}
		//b=c;//报错
		b.addAll(c);//不报错
		//b=getListByNumber(d);//报错
		b=getListByNumber(c);//不报错
		
		for(Number t:b){
			System.out.println(t);
		}
		
		
	}
	
	@Test
	public void testNumberToAtomicInteger(){
		ArrayList<Number> b=new  ArrayList<Number>();
		ArrayList<AtomicInteger> c=new  ArrayList<AtomicInteger>();
		j=1;
		for(int i=0;i<10;i++){
			b.add(j);
		}
		//c=b;//报错
		//c.addAll(b);//报错
		c=getListByAtomicInteger(b);
		for(AtomicInteger t:c){
			System.out.println(t);
		}
		
		
	}
	
	/**
	 *· ArrayList<? extends Number> list
	 * 规定，入参Number为泛型类型的上限，即入参泛型类型可以为Number或者其子类
	 * 子类可以自动向父类转化,但是父类不能转化为子类
	 * @param list
	 * @return
	 */
	public ArrayList<Number> getListByNumber(ArrayList<? extends Number> list){
		ArrayList<Number> li=new ArrayList<Number>();
		for(Object o:list){
			if(o instanceof Number){
				System.out.println("入参类型属于Number的子类");
				li.add((Number)o);
			}
		}
		return li;
	}
	
	/**
	 * ArrayList<? super AtomicInteger> list
	 * 规定泛型类型下限，入参泛型类必须为AtomicInteger或者其之上的超类【public class AtomicInteger extends Number】
	 * 父类不可以向子类转化
	 * @param list
	 * @return
	 */
	public ArrayList<AtomicInteger> getListByAtomicInteger(ArrayList<? super AtomicInteger> list){
		ArrayList<AtomicInteger> li=new ArrayList<AtomicInteger>();
		for(Object t:list){
			//父类不会是子类的实现，所以下面的代码不会运行，避免强制转化
			if(t instanceof AtomicInteger){
				li.add((AtomicInteger) t);
			}
			
			//li.add((AtomicInteger) t);//强制父类转化为子类，运行时报错
			
			li.add(new AtomicInteger((Integer) t));//单独处理，可以运行
		}
		return li;
	}
	

}
