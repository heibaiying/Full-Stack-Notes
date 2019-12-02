package com.heibaiying.creational.singleton;

import java.lang.reflect.Constructor;

/**
 * 利用反射破坏单例
 */
public class ReflectionDamage {
	public static void main(String[] args) throws Exception {
		Constructor<HungrySingleton> constructor = HungrySingleton.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		HungrySingleton hungrySingleton = constructor.newInstance();
		HungrySingleton instance = HungrySingleton.getInstance();
		System.out.println(hungrySingleton == instance);
	}
}
