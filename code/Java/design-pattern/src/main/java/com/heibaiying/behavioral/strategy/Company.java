package com.heibaiying.behavioral.strategy;

public class Company {

	private Strategy strategy;

	public Company setStrategy(Strategy strategy) {
		this.strategy = strategy;
		return this;
	}

	public void execute() {
		strategy.execute();
	}
}
