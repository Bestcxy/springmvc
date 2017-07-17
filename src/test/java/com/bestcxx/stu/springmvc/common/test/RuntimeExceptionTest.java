package com.bestcxx.stu.springmvc.common.test;

import java.io.IOException;


//RuntimeException 继承了 Exception
//RuntimeException 为运行时异常
//RuntimeException 以及其子类 都是非受检异常，可以捕获，继续抛出异常、不处理
//Exception类异常为普通异常,需要处理
//其他异常类则为受检异常，受检异常必须捕获或者继续抛出异常

//异常的分类
//Error错误：JVM内部的严重问题。无法恢复。程序人员不用处理。
//Exception异常：普通的问题。通过合理的处理，程序还可以回到正常执行流程。要求编程人员要进行处理。
//RuntimeException:也叫非受检异常(unchecked exception).这类异常是编程人员的逻辑问题。应该承担责任。Java编译器不进行强制要求处理。 也就是说，这类异常再程序中，可以进行处理，也可以不处理。
//非RuntimeException:也叫受检异常(checked exception).这类异常是由一些外部的偶然因素所引起的。Java编译器强制要求处理。也就是说，程序必须进行对这类异常进行处理。

//异常举例
//非受检的：NullPointerException,ClassCastException,ArrayIndexsOutOfBoundsException,ArithmeticException(算术异常，除0溢出)
//受检：Exception,FileNotFoundException,IOException,SQLException.
public class RuntimeExceptionTest {
	
	public void ma() throws RuntimeException{
		System.out.println("RuntimeException 及其子类下的为非受检异常");
	}
	
	public void mb() throws IOException{
		System.out.println("IOException 为受检异常");
	}
	
	public void mc() throws Exception{
		System.out.println("Exception 为受检异常");
	}
	
	public static void main(String[] args) {
		RuntimeExceptionTest r=new RuntimeExceptionTest();
		//非受检异常可以不做处理
		r.ma();
		
		//受检异常则必须进行处理，使用try...catch或者再次抛出异常
		try {
			r.mb();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			r.mc();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
