package com.heibaiying.atomic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class J6_SynchronousQueue {

	private static SynchronousQueue<Double> queue = new SynchronousQueue<>();

	static class ReadThread implements Runnable {
		@Override
		public void run() {
			System.out.println("读线程启动");
			while (true) {
				try {
					Double peek = queue.take();
					System.out.println("读线程获取值:" + peek);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	static class WriteThread implements Runnable {
		@Override
		public void run() {
			System.out.println("写线程写入值");
			try {
				queue.put(Math.random());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) throws InterruptedException {
		new Thread(new ReadThread()).start();
		Thread.sleep(3000);
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
		pool.scheduleAtFixedRate(new WriteThread(), 0, 2, TimeUnit.SECONDS);
	}
}
