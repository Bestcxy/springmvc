package com.bestcxx.stu.springmvc.thread;

/**
 * 线程组测试
 * @author WuJieJecket
 *
 */
public class ThreadGroupTest implements Runnable{

	public static void main(String[] args) {
		ThreadGroup threadGroup=new  ThreadGroup("ThreadGroup");//实例化线程组

		ThreadGroup threadGroup2=new  ThreadGroup(threadGroup,"ThreadGroup2");//增加子线程组
		
		Thread t0=new Thread(threadGroup,new ThreadGroupTest(),"线程0");
		Thread t1=new Thread(threadGroup,new ThreadGroupTest(),"线程1");
		
		Thread t2=new Thread(threadGroup2,new ThreadGroupTest(),"线程2");
		Thread t3=new Thread(threadGroup2,new ThreadGroupTest(),"线程3");
	
		
		t0.start();
		t1.start();
		
		t2.start();
		t3.start();
		
		System.out.println("线程组及子线程组包含的线程总数的估值:"+threadGroup.activeCount());//线程组及子线程组包含的线程总数的估值
		System.out.println("包含的子线程组的估值:"+threadGroup.activeGroupCount());//包含的子线程组的估值
		
		threadGroup.list();
	
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(System.currentTimeMillis()+" threadGroup:"+Thread.currentThread().getThreadGroup().getName()+"; Thread:"+Thread.currentThread().getName());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

