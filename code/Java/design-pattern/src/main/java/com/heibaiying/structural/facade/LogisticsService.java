package com.heibaiying.structural.facade;

public class LogisticsService {
	public void ship(Phone phone) {
		System.out.println(phone.getName() + "已经发货，请注意查收...");
	}
}
