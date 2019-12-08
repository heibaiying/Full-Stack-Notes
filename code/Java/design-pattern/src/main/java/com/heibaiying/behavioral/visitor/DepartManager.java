package com.heibaiying.behavioral.visitor;

public class DepartManager implements Visitor {

	@Override
	public void visit(PublicArchive publicArchive) {
		System.out.println("所有公开档案");
	}

	@Override
	public void visit(SecretArchive secretArchive) {
		System.out.println("三级以下权限的加密档案");
	}
}
