package com.heibaiying.behavioral.interpreter;

import java.util.HashMap;

public abstract class Expression {
	//解析公式和数值，其中var中的key值是公式中的参数，value值是具体的数字
	public abstract int interpreter(HashMap<String, Integer> var);
}
