package com.heibaiying.structural.decorator;

public class FilmDecorator extends Decorator {

	public FilmDecorator(Phone phone) {
		super(phone);
	}

	@Override
	public int getPrice() {
		return super.getPrice() + 100;
	}

	@Override
	public String getDesc() {
		return super.getDesc() + " + 钢化膜";
	}
}
