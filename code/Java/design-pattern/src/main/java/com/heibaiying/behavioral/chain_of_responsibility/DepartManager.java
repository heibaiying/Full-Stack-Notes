package com.heibaiying.behavioral.chain_of_responsibility;

public class DepartManager extends Leader {

	@Override
	public void approval(Application application) {
		System.out.println(application.getTitle() + "被部门经理审批通过");
		if (application.getDayNum() >= 5) {
			leader.approval(application);
		}
	}
}
