package com.heibaiying.threadGroup;

public class J2_Daemon {

	static class Task implements Runnable {
		@Override
		public void run() {
			Thread current = Thread.currentThread();
			System.out.println("当前线程id: " + current.getId() + "当前所属线程组: " + current.getThreadGroup().getName());
		}
	}

	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("java线程组");
		Thread thread1 = new Thread(group, new Task());
		Thread thread2 = new Thread(group, new Task());
		Thread thread3 = new Thread(group, new Task());
		thread1.setDaemon(true);
		thread2.setDaemon(true);
		thread3.setDaemon(true);
		thread1.start();  // 通常不会执行
		thread2.start();  // 通常不会执行
		thread3.start();  // 通常不会执行
	}
}
