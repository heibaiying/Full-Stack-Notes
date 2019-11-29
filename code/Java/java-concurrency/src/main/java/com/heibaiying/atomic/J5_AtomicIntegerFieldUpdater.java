package com.heibaiying.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class J5_AtomicIntegerFieldUpdater {

	static class Task implements Runnable {

		private Candidate candidate;
		private CountDownLatch latch;
		private AtomicIntegerFieldUpdater fieldUpdater;

		Task(CountDownLatch latch, Candidate candidate, AtomicIntegerFieldUpdater fieldUpdater) {
			this.candidate = candidate;
			this.latch = latch;
			this.fieldUpdater = fieldUpdater;
		}

		@Override
		public void run() {
			fieldUpdater.incrementAndGet(candidate);
			latch.countDown();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int number = 100000;
		CountDownLatch latch = new CountDownLatch(number);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Candidate candidate = new Candidate("候选人", 0);
		// 使用字段更新型来保证其线程安全
		AtomicIntegerFieldUpdater<Candidate> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");
		for (int i = 0; i < number; i++) {
			executorService.execute(new Task(latch, candidate, fieldUpdater));
		}
		latch.await();
		System.out.println(candidate.getName() + "获得票数:" + candidate.getScore());
		executorService.shutdown();
	}


	private static class Candidate {

		private String name;

		// 1. 不能声明为private  2. 必须用volatile关键字修饰
		public volatile int score;

		Candidate(String name, int score) {
			this.name = name;
			this.score = score;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
