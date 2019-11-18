package com.heibaiying.forkAndJoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Long> {

	private Long start;
	private Long end;
	private static long hold = 50L;

	CountTask(Long start, Long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long sum = 0L;
		// 一定要保证能够进进入if中的终止条件，如果无限制的拆分,可能会导致栈溢出
		if (end - start <= hold) {
			// 假设一个最小的计算都是耗时的
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (long i = start; i < end; i++) {
				sum += i;
			}
		} else {
			List<CountTask> countTasks = new ArrayList<>();
			long l = (end - start) / hold;
			for (int i = 0; i < l; i++) {
				CountTask task = new CountTask(start + i * hold, start + (i + 1) * hold);
				countTasks.add(task);
				task.fork();
				if (i == l - 1) {
					CountTask countTask = new CountTask(start + (i + 1) * hold, end);
					countTasks.add(countTask);
					countTask.fork();
				}
			}
			for (CountTask countTask : countTasks) {
				sum += countTask.join();
			}
		}
		return sum;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ForkJoinPool forkJoinPool = new ForkJoinPool(100);
		CountTask task = new CountTask(0L, 10000L);
		ForkJoinTask<Long> result = forkJoinPool.submit(task);
		Long aLong = result.get();
		System.out.println("结果为" + aLong);
	}
}
