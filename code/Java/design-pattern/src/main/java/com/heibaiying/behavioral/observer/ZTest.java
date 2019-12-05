package com.heibaiying.behavioral.observer;

public class ZTest {

	public static void main(String[] args) {
		Business business = new Business();
		business.addObserver(new User("用户1"));
		business.addObserver(new User("用户2"));
		business.addObserver(new User("用户3"));
		business.notifyObservers("商品促销通知");
	}

}
