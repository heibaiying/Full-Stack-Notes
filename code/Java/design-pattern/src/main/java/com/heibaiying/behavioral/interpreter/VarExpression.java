package com.heibaiying.behavioral.interpreter;

import java.util.HashMap;

public class VarExpression extends Expression {

	private String key;

	public VarExpression(String key) {
		this.key = key;
	}

	//从map中取之
	public int interpreter(HashMap<String, Integer> var) {
		return var.get(this.key);
	}
}
