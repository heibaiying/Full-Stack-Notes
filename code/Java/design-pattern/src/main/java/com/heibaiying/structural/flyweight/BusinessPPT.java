package com.heibaiying.structural.flyweight;

public class BusinessPPT extends PowerPoint {

	public BusinessPPT(String copyright) {
		super(copyright);
	}

	@Override
	void create() {
		System.out.println("商务类PPT模板");
	}
}
