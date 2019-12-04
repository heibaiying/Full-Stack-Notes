package com.heibaiying.structural.decorator;

public abstract class Decorator extends Phone {

	private Phone phone;

	public Decorator(Phone phone) {
		this.phone = phone;
	}

	@Override
	public int getPrice() {
		return phone.getPrice();
	}

	@Override
	public String getDesc() {
		return phone.getDesc();
	}
}
