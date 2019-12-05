package com.heibaiying.behavioral.strategy;

public class ZTest {
	public static void main(String[] args) {
		// 营业额
		int turnover = Integer.parseInt(args[0]);
		Company company = new Company();
		if (turnover > 1000) {
			company.setStrategy(new BonusStrategy()).execute();
		} else if (turnover > 100) {
			company.setStrategy(new TravelStrategy()).execute();
		} else {
			company.setStrategy(new WorkOvertimeStrategy()).execute();
		}
	}
}
