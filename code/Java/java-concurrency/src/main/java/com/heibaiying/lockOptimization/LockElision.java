package com.heibaiying.lockOptimization;

/**
 * 锁消除
 */
public class LockElision {

	private String toJson(Employee employee) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("name:").append(employee.getName());
		buffer.append("age:").append(employee.getAge());
		buffer.append("birthday:").append(employee.getBirthday());
		return buffer.toString();
	}
}


