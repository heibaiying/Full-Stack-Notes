package com.heibaiying.structural.decorator;

public class MiPhone extends Phone {

	@Override
	public int getPrice() {
		return 1999;
	}

	@Override
	public String getDesc() {
		return "MiPhone";
	}
}
