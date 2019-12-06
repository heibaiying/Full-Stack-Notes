package com.heibaiying.behavioral.chain_of_responsibility;

public abstract class Leader {

	protected Leader leader;

	public Leader setNextLeader(Leader leader) {
		this.leader = leader;
		return leader;
	}

	public abstract void approval(Application application);

}
