package com.heibaiying.structural.bridge;

public class Test {
	public static void main(String[] args) {
		new Square().setColor(new Red()).getDesc();
		new Square().setColor(new Blue()).getDesc();
		new Round().setColor(new Blue()).getDesc();
		new Round().setColor(new Yellow()).getDesc();
	}
}
