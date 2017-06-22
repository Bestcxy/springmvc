package com.bestcxx.stu.springmvc.thread;

public class JoinThreadTest{
	
	//验证：子线程0.join() 会使子线程0 加入到父线程中，即父线程会等待 子线程0 结束之后继续运行，如果多个子线程调用 join() 且没有设置等待时间，则主线程等待最长时间子线程结束后运行
	//实验思路：
	//	父线程开始休眠 1000ms
	//	子线程 t0.start (内部休眠 2000 ms) 、子线程 t1.start (内部休眠4000s)
	//  	当 仅子线程 t0.join()-父线程等待t0 而不等待 t1
	//		当 子线程t0.join() 且 t1.join() 则父线程等待 t0 和 t1
	
	public static void main(String[] args) {
		final int sleepNum=1000;//休眠时间  单位/毫秒
		final int sleepNum2=2000;//休眠时间  单位/毫秒
		final int sleepNum3=4000;//休眠时间  单位/毫秒
		
		//子线程设置：休眠 sleepNum ms
		Thread t0=new Thread(
				new Runnable(){

					@Override
					public void run() {
						System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+" 启动");
						System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+" 开始休眠"+sleepNum2+" ms");
						try {
							Thread.sleep(sleepNum2);
							System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+" 休眠结束");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				},"子线程1");
		
		//子线程设置：休眠 sleepNum ms
				Thread t1=new Thread(
						new Runnable(){

							@Override
							public void run() {
								System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+" 启动");
								System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+" 开始休眠"+sleepNum3+" ms");
								try {
									Thread.sleep(sleepNum3);
									System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName()+" 休眠结束");
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
						},"子线程2");
		
				
		/**********************************下是运行区**********************************************************/
		System.out.println(System.currentTimeMillis()+"主线程启动");
		
		System.out.println(System.currentTimeMillis()+"主线程开始休眠 "+sleepNum+" ms");
		try {
			Thread.sleep(sleepNum);
			System.out.println(System.currentTimeMillis()+"主线程休眠 结束");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t0.start();
		t1.start();
		//只有 t0 设置 join
		//主线程等待 t0 子线程运行结束，而不会等待 t1 子线程运行结束
		try {
			t0.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(System.currentTimeMillis()+"主线程 结束");
			
	}

}

