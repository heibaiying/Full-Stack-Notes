package com.heibaiying.structural.bridge;

public abstract class Shape {

	private Color color;

	public Shape setColor(Color color) {
		this.color = color;
		return this;
	}

	public Color getColor() {
		return color;
	}

	public abstract void getDesc();
}
