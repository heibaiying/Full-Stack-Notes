package com.heibaiying.creational.singleton;

import java.io.*;

/**
 * 利用序列化破坏单例
 */
public class SerializationDamage {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		HungrySingleton instance = HungrySingleton.getInstance();
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("SingletonFile"));
		outputStream.writeObject(instance);
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("SingletonFile")));
		HungrySingleton newInstance = (HungrySingleton) inputStream.readObject();
		System.out.println(instance == newInstance);
	}
}
