package com.heibaiying.structural.decorator;

public class ShellDecorator extends Decorator {

	public ShellDecorator(Phone phone) {
		super(phone);
	}

	@Override
	public int getPrice() {
		return super.getPrice() + 200;
	}

	@Override
	public String getDesc() {
		return super.getDesc() + " + 手机壳";
	}

}
