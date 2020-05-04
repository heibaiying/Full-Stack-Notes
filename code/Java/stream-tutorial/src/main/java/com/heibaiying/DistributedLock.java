package com.heibaiying;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryNTimes;

import java.util.concurrent.TimeUnit;

public class DistributedLock {


	public static void main(String[] args) throws Exception {


		RetryPolicy retryPolicy = new RetryNTimes(3, 5000);
		CuratorFramework client = CuratorFrameworkFactory.builder()
			.connectString("192.168.0.105:2181")
			.sessionTimeoutMs(10000).retryPolicy(retryPolicy)
			.namespace("mySpace").build();
		client.start();

		// 1. 创建分布式锁
		InterProcessMutex lock = new InterProcessMutex(client, "/distributed/myLock");

		// 2.尝试获取分布式锁
		if (lock.acquire(10, TimeUnit.SECONDS)) {
			try {
				System.out.println("模拟业务耗时");
				Thread.sleep(3 * 1000);
			} finally {
				// 3.释放锁
				lock.release();
			}
		}

		client.close();
	}

}
