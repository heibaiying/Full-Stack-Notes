package com.heibaiying.behavioral.visitor;

/**
 * 公开档案
 */
public class PublicArchive implements Archive {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
