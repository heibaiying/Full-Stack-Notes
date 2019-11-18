package com.heibaiying.threadGroup;

public class J1_ThreadGroup {

	static class Task implements Runnable {
		@Override
		public void run() {
			Thread current = Thread.currentThread();
			System.out.println("当前线程id: " + current.getId() + " 当前所属线程组: " + current.getThreadGroup().getName());
		}
	}

	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("java线程组");
		// 指定所属的线程组
		Thread thread1 = new Thread(group, new Task());
		Thread thread2 = new Thread(group, new Task());
		thread1.start();
		thread2.start();
	}
}
