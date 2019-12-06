package com.heibaiying.behavioral.chain_of_responsibility;

public class President extends Leader {

	@Override
	public void approval(Application application) {
		System.out.println(application.getTitle() + "被总经理审批通过");
	}
}
