package com.bestcxx.stu.springmvc.thread;

import java.util.concurrent.Callable;

/**
 * 
 * @theme 
 * @author wujie
 * @Datetime 2017年6月19日
 * Desc:
 * Callable接口是java 5新增的接口，不是Runnable接口的子接口，
 * 所以Callable对象不能直接作为Thread类的target。
 * Callable 的 call() 方法有一个返回值，需要被覆盖重写，返回值的类型由实现类确定-<泛型>
 * 它是作为线程执行体才被调用的。
 *  在工具开发包中，java 5 提供了Future接口来代表Callable接口里的call()方法的返回值，
 *  并且为Future接口提供了一个FutureTask实现类，
 *  该实现类实现了Future接口，
 *  并且实现了Runnable接口——可以作为Thread类的target。
 *  实际上这里的FutureTask类实现了一个桥梁的作用，
 *  用于连接Callable对象和Thread对象。
 *  需要注意的是Callable接口有泛型限制，Callable接口里的泛型形参类型，
 *  与call()方法的返回值类型相同。
 */
public class ThreadImplementsCallable implements Callable<Boolean> {

	@Override
	public Boolean call() throws Exception {
		boolean flag=true;
		System.out.println("多线程实现 Callable 接口，返回:"+flag+",getName:"+Thread.currentThread().getName()+",id:"+Thread.currentThread().getId());
		return flag;
	}

}
