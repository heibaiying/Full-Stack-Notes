package com.heibaiying.behavioral.strategy;

public class BonusStrategy implements Strategy {
	@Override
	public void execute() {
		System.out.println("奖金激励");
	}
}
