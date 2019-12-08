package com.heibaiying.behavioral.visitor;

public class ZTest {
	public static void main(String[] args) {
		Company company = new Company();
		company.add(new SecretArchive());
		company.add(new PublicArchive());
		company.accept(new DepartManager());
		company.accept(new President());
	}
}
