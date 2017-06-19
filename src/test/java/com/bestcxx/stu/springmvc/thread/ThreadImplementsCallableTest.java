package com.bestcxx.stu.springmvc.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class ThreadImplementsCallableTest {
	
	@Test
	public void test0(){
		ThreadImplementsCallable t0=new ThreadImplementsCallable();
		
		FutureTask<Boolean> f0=new FutureTask<Boolean>(t0);
		
		new Thread(f0).start();
		
		try {
			System.out.println("有返回值，且可以捕获异常的线程，返回结果："+f0.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
