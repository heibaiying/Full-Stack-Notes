package com.heibaiying.lockSupport;

import java.util.concurrent.locks.LockSupport;

public class J1_LockSupport {

	static class Task implements Runnable {
		@Override
		public void run() {
			long id = Thread.currentThread().getId();
			System.out.println("线程" + id + "开始阻塞");
			LockSupport.park();
			System.out.println("线程" + id + "解除阻塞");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread01 = new Thread(new Task());
		Thread thread02 = new Thread(new Task());
		thread01.start();
		thread02.start();
		Thread.sleep(3000);
		System.out.println("主线程干预");
		LockSupport.unpark(thread01);
		LockSupport.unpark(thread02);
	}
}
