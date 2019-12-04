package com.heibaiying.structural.bridge;

public class Square extends Shape {

	@Override
	public void getDesc() {
		System.out.println(getColor().getDesc() + "正方形");
	}
}
