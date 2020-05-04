package com.heibaiying;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.BinaryOperator;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID() + ":" + Thread.currentThread().getId());

	}

	/**
	 * 进行求和
	 *
	 * @param list
	 * @param initValue
	 * @param binaryOperator
	 * @param <T>
	 * @return
	 */
	public static <T> T reduce(List<T> list, T initValue, BinaryOperator<T> binaryOperator) {
		for (T t : list) {
			initValue = binaryOperator.apply(initValue, t);
		}
		return initValue;
	}

	/**
	 * 集合过滤
	 *
	 * @param list      待过滤的集合
	 * @param predicate 函数式接口
	 * @param <T>       集合中元素的类型
	 * @return 满足条件的元素的集合
	 */
	public static <T> List<T> filter(List<T> list, CustomPredicate<T> predicate) {
		ArrayList<T> result = new ArrayList<>();
		for (T t : list) {
			if (predicate.test(t)) result.add(t);
		}
		return result;
	}


	/**
	 * 定义接口
	 *
	 * @param <T> 参数类型
	 */
	@FunctionalInterface
	public interface CustomPredicate<T> {
		// 判断是否满足过滤标准
		boolean test(T t);
	}

}
