package com.heibaiying.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class J3_Method03 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Task task = new Task();
		FutureTask<Integer> futureTask = new FutureTask<>(task);
		new Thread(futureTask).start();
		System.out.println("获得线程返回值：" + futureTask.get());
	}
}

class Task implements Callable<Integer> {

	@Override
	public Integer call() {
		return 100;
	}
}