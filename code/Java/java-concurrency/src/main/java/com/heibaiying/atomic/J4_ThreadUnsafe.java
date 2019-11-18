package com.heibaiying.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class J4_ThreadUnsafe {

	static class Task implements Runnable {

		private Candidate candidate;
		private CountDownLatch latch;

		Task(CountDownLatch latch, Candidate candidate) {
			this.candidate = candidate;
			this.latch = latch;
		}

		@Override
		public void run() {
			candidate.setScore(candidate.getScore() + 1);
			latch.countDown();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int number = 100000;
		CountDownLatch latch = new CountDownLatch(number);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Candidate candidate = new Candidate("候选人", 0);
		for (int i = 0; i < number; i++) {
			executorService.execute(new Task(latch, candidate));
		}
		latch.await();
		System.out.println(candidate.getName() + "获得票数:" + candidate.getScore());
		executorService.shutdown();
	}


	private static class Candidate {

		private String name;
		private volatile int score;

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
