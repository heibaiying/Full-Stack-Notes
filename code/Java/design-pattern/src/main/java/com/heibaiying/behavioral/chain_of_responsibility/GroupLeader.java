package com.heibaiying.behavioral.chain_of_responsibility;

public class GroupLeader extends Leader {

	@Override
	public void approval(Application application) {
		System.out.println(application.getTitle() + "被组长审批通过");
		if (application.getDayNum() >= 3) {
			leader.approval(application);
		}
	}
}
