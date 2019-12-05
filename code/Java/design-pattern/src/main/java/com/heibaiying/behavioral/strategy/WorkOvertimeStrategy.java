package com.heibaiying.behavioral.strategy;

public class WorkOvertimeStrategy implements Strategy {
	@Override
	public void execute() {
		System.out.println("奖励加班");
	}
}
