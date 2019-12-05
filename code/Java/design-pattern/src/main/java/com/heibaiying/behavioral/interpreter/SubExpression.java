package com.heibaiying.behavioral.interpreter;

import java.util.HashMap;

public class SubExpression extends SymbolExpression {
	public SubExpression(Expression left,Expression right){
		super(left,right);
	}
	//左右两个表达式相减
	public int interpreter(HashMap<String, Integer> var) {
		return super.left.interpreter(var) - super.right.interpreter(var);
	}
}
