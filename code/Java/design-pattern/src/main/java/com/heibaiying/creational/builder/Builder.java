package com.heibaiying.creational.builder;

public abstract class Builder {

	protected Phone phone = new Phone();

	public abstract void addProcessor();

	public abstract void addCamera();

	public abstract void addScreen();

	public Phone produce() {
		return phone;
	}
}
