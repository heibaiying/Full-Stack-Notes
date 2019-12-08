package com.heibaiying.structural.flyweight;


import java.lang.reflect.Constructor;
import java.util.HashMap;

public class PPTFactory {

	private HashMap<String, PowerPoint> hashMap = new HashMap<>();

	public PowerPoint getPPT(Class<? extends PowerPoint> clazz) {
		try {
			String name = clazz.getName();
			if (hashMap.keySet().contains(name)) {
				return hashMap.get(name);
			}
			Constructor<?> constructor = Class.forName(name).getConstructor(String.class);
			PowerPoint powerPoint = (PowerPoint) constructor.newInstance("PPT工厂版本所有");
			hashMap.put(name, powerPoint);
			return powerPoint;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
