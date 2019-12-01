package com.heibaiying.creational.builder;

public class Manager {

	private Builder builder;

	public Manager(Builder builder) {
		this.builder = builder;
	}

	public Phone buy() {
		builder.addCamera();
		builder.addProcessor();
		builder.addScreen();
		return builder.produce();
	}
}
