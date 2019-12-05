package com.heibaiying.behavioral.template;

public class SmartPhone extends Phone {

	@Override
	boolean needAddNFC() {
		return true;
	}

	@Override
	void packaged() {
		System.out.println("附赠耳机一副");
	}
}
