package com.heibaiying.behavioral.strategy;

public class TravelStrategy implements Strategy {
	@Override
	public void execute() {
		System.out.println("集体旅游");
	}
}
