package com.heibaiying.creational.singleton;

import java.io.Serializable;

/**
 * 利用静态代码块来实现饿汉式单例
 */
public class HungrySingleton implements Serializable {

	private static final HungrySingleton instance;

	static {
		instance = new HungrySingleton();
	}

	private HungrySingleton() {
		if (instance != null) {
			throw new RuntimeException("单例模式禁止反射调用");
		}
	}

	public static HungrySingleton getInstance() {
		return instance;
	}

	private Object readResolve() {
		return instance;
	}
}
