package com.heibaiying.behavioral.chain_of_responsibility;

public abstract class Leader {

	protected Leader leader;

	// 责任链模式的核心：其需要持有一个后继者
	public Leader setNextLeader(Leader leader) {
		this.leader = leader;
		return leader;
	}

	public abstract void approval(Application application);

}
