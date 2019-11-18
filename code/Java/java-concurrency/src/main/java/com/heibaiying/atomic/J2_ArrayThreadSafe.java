package com.heibaiying.atomic;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class J2_ArrayThreadSafe {

	// 对集合本生的操作线程安全
	private static LinkedBlockingQueue<Integer> LinkedBlockingQueue = new LinkedBlockingQueue<>();
	//对集合本生的操作线程安全
	private static Vector<Integer> vector = new Vector<>();
	//普通集合
	private static ArrayList<Integer> arrayList = new ArrayList<>();

	static class Task implements Runnable {

		private CountDownLatch latch;

		Task(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				LinkedBlockingQueue.add(i);
				vector.add(i);
				arrayList.add(i);
			}
			latch.countDown();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int number = 1000;
		CountDownLatch latch = new CountDownLatch(number);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < number; i++) {
			executorService.execute(new Task(latch));
		}
		latch.await();
		System.out.println("集合本生的线程安全：");
		System.out.println("LinkedBlockingQueue size : " + LinkedBlockingQueue.size());
		System.out.println("vector size : " + vector.size());
		System.out.println("arrayList size : " + arrayList.size());
		executorService.shutdown();
	}
}
