package com.heibaiying.behavioral.visitor;

public interface Visitor {
	void visit(PublicArchive publicArchive);
	void visit(SecretArchive secretArchive);
}
