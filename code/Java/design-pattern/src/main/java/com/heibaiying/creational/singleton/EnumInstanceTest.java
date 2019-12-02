package com.heibaiying.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

public class EnumInstanceTest {
	public static void main(String[] args) throws Exception {
		// 序列化攻击
		EnumInstance instance = EnumInstance.getInstance();
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("EnumSingletonFile"));
		outputStream.writeObject(instance);
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("EnumSingletonFile")));
		EnumInstance newInstance = (EnumInstance) inputStream.readObject();
		System.out.println(instance == newInstance);
		// 反射攻击，Enum类中只有一个两个参数的构造器：Enum(String name, int ordinal)
		Constructor<EnumInstance> constructor = EnumInstance.class.getDeclaredConstructor(String.class, int.class);
		constructor.setAccessible(true);
		EnumInstance enumInstance = constructor.newInstance("name", 0);
		System.out.println(instance == enumInstance);
	}
}
