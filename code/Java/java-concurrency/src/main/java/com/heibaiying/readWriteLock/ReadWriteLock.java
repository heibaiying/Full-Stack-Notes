package com.heibaiying.readWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

	// 可重入锁
	private static ReentrantLock reentrantLock = new ReentrantLock();
	// 读写锁
	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	// 读锁
	private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
	// 写锁
	private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

	// 待赋值的变量
	private static String i = "";

	//写方法
	static class Write implements Runnable {

		private Lock lock;
		private String value;

		Write(Lock lock, String value) {
			this.lock = lock;
			this.value = value;
		}

		@Override
		public void run() {
			try {
				lock.lock();
				Thread.sleep(1000);
				i = value;
				System.out.println(Thread.currentThread().getName() + "写入值" + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	//读方法
	static class Read implements Runnable {

		private Lock lock;

		Read(Lock lock) {
			this.lock = lock;
		}

		@Override
		public void run() {
			try {
				lock.lock();
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + "读取到值" + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}


	public static void main(String[] args) throws InterruptedException {

		// 写锁是排它的，但读锁是共享的，耗时3秒左右
		for (int j = 0; j < 2; j++) {
			Thread thread = new Thread(new Write(writeLock, String.valueOf(j)));
			thread.start();
		}
		for (int j = 0; j < 18; j++) {
			Thread thread = new Thread(new Read(readLock));
			thread.start();
		}


		// 使用重入锁时耗时20秒左右
		for (int j = 0; j < 2; j++) {
			Thread thread = new Thread(new Write(reentrantLock, String.valueOf(j)));
			thread.start();
		}
		for (int j = 0; j < 18; j++) {
			Thread thread = new Thread(new Read(reentrantLock));
			thread.start();
		}
	}
}
