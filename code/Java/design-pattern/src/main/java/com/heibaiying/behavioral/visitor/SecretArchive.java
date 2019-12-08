package com.heibaiying.behavioral.visitor;

/**
 * 加密档案
 */
public class SecretArchive implements Archive {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
