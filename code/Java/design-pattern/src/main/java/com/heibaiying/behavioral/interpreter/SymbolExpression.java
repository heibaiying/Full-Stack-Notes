package com.heibaiying.behavioral.interpreter;

public abstract class SymbolExpression extends Expression {
	protected Expression left;
	protected Expression right;

	//所有的解析公式都应只关心自己左右两个表达式的结果
	public SymbolExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
}
