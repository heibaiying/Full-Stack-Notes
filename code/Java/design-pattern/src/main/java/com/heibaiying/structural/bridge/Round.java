package com.heibaiying.structural.bridge;

public class Round extends Shape {

	@Override
	public void getDesc() {
		System.out.println(getColor().getDesc() + "圆形");
	}
}
