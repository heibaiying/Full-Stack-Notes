package com.heibaiying.behavioral.interpreter;

import java.util.HashMap;
import java.util.Stack;

public class Calculator {
	//定义表达式
	private Expression expression;

	//构造函数传参，并解析
	public Calculator(String expStr) {
		//定义一个栈，安排运算的先后顺序
		Stack<Expression> stack = new Stack<>();
		//表达式拆分为字符数组
		char[] charArray = expStr.toCharArray();
		//运算
		Expression left;
		Expression right;
		for (int i = 0; i < charArray.length; i++) {
			switch (charArray[i]) {
				case '+': //加法
					//加法结果放到栈中
					left = stack.pop();
					right = new VarExpression(String.valueOf(charArray[++i]));
					stack.push(new AddExpression(left, right));
					break;
				case '-':
					left = stack.pop();
					right = new VarExpression(String.valueOf(charArray[++i]));
					stack.push(new SubExpression(left, right));
					break;
				default: //公式中的变量
					stack.push(new VarExpression(String.valueOf(charArray[i])));
			}
		}
		//把运算结果抛出来
		this.expression = stack.pop();
	}

	//开始运算
	public int run(HashMap<String, Integer> var) {
		return this.expression.interpreter(var);
	}
}
