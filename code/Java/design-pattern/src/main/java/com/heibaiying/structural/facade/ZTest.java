package com.heibaiying.structural.facade;

public class ZTest {
	public static void main(String[] args) {
		Phone phone = new Phone("XXX手机");
		OrderService orderService = new OrderService();
		orderService.order(phone);
	}
}
