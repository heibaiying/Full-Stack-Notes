package com.heibaiying.atomic;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class J3_ArrayElementThreadUnsafe {

	private static int capacity = 10;
	// 保证对集合内元素的操作具有原子性
	private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(capacity);
	// 对集合内元素的操作线程不安全
	private static Vector<Integer> vector = new Vector<>(capacity);
	// 对集合内元素的操作线程不安全
	private static ArrayList<Integer> arrayList = new ArrayList<>(capacity);

	static {
		for (int i = 0; i < capacity; i++) {
			arrayList.add(0);
			vector.add(0);
		}
	}

	static class Task implements Runnable {

		private CountDownLatch latch;

		Task(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				int num = i % capacity;
				atomicIntegerArray.getAndIncrement(num);
				vector.set(num, vector.get(num) + 1);
				arrayList.set(num, arrayList.get(num) + 1);
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
		System.out.println("集合内元素的线程安全：");
		System.out.println("atomicIntegerArray size : " + atomicIntegerArray);
		System.out.println("vector size : " + vector);
		System.out.println("arrayList size : " + arrayList);
		executorService.shutdown();
	}
}
