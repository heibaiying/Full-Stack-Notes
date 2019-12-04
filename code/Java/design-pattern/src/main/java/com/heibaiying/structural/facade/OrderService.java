package com.heibaiying.structural.facade;

public class OrderService {

	private EnvInspectionService inspectionService = new EnvInspectionService();
	private AccountService accountService = new AccountService();
	private LogisticsService logisticsService = new LogisticsService();

	public void order(Phone phone) {
		if (inspectionService.evInspection()) {
			if (accountService.balanceCheck()) {
				System.out.println("支付成功");
				logisticsService.ship(phone);
			}
		}
	}
}
