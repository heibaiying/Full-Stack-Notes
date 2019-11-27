package com.heibaiying.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 计划任务
 */
public class J2_ScheduledTask {

	private static long cacheTime = System.currentTimeMillis();

	static class Task implements Runnable {

		private String type;

		Task(String type) {
			this.type = type;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(5000);
				long nowTime = System.currentTimeMillis();
				System.out.println(type + Thread.currentThread().getId() + "执行耗时" + (nowTime - cacheTime) + "毫秒");
				cacheTime = nowTime;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// 为避免相互间的影响，以下各种场景最好分别测试：
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
		// 只执行一次
		pool.schedule(new Task("schedule"), 2, TimeUnit.SECONDS);
		// 指定2秒为固定周期执行，因为项目执行耗时5秒，此时项目结束会立马执行下一次任务，所以输出的时间间隔为5秒
		pool.scheduleAtFixedRate(new Task("FixedRate"), 0, 2, TimeUnit.SECONDS);
		// 总是在上一次项目结束后间隔指定周期执行，因为项目耗时5秒，还需要间隔2秒执行，所以输出的时间间隔为7秒
		pool.scheduleWithFixedDelay(new Task("WithFixedDelay"), 0, 2, TimeUnit.SECONDS);
		// pool.shutdown();
	}

}
