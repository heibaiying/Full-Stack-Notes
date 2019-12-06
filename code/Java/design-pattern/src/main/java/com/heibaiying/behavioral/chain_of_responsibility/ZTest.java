package com.heibaiying.behavioral.chain_of_responsibility;

public class ZTest {
	public static void main(String[] args) {
		GroupLeader groupLeader = new GroupLeader();
		DepartManager departManager = new DepartManager();
		President president = new President();
		groupLeader.setNextLeader(departManager).setNextLeader(president);
		groupLeader.approval(new Application("事假单", 3));
		groupLeader.approval(new Application("婚假单", 10));
	}
}
