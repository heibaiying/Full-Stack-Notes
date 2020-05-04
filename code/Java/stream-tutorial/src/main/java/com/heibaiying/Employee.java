package com.heibaiying;

public class Employee {
	private String name;
	private String gender;
	private String company;
	private int age;
	private boolean isOfficial;

	public Employee(String name, String gender, String company, int age) {
		this.name = name;
		this.gender = gender;
		this.company = company;
		this.age = age;
	}

	Employee(String name, int age,boolean isOfficial) {
		this.name = name;
		this.age = age;
		this.isOfficial = isOfficial;
	}

	@Override
	public String toString() {
		return "Employee{" +
			"name='" + name + '\'' +
			'}';
	}

	public boolean isOfficial() {
		return isOfficial;
	}

	public void setOfficial(boolean official) {
		isOfficial = official;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
