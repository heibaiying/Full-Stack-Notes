package com.heibaiying.behavioral.template;

public class OlderPhone extends Phone {

	@Override
	boolean needAddNFC() {
		return false;
	}

	@Override
	void packaged() {
		System.out.println("附赠一个手机壳");
	}
}
