package com.lock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;

public class RedisLock {

	public static void main(String[] args) {
		Config config = new Config();
		config.setTransportMode(TransportMode.EPOLL);
		config.useSingleServer().setAddress("redis://127.0.0.1:7181");
		RedissonClient client = Redisson.create(config);
		RLock mylock = client.getLock("mylock");
		mylock.lock();
	}
}
