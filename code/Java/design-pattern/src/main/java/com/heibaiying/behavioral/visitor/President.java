package com.heibaiying.behavioral.visitor;

public class President implements Visitor {

	@Override
	public void visit(PublicArchive publicArchive) {
		System.out.println("所有公开档案");
	}

	@Override
	public void visit(SecretArchive secretArchive) {
		System.out.println("所有加密档案");
	}
}
