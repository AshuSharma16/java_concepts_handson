package com.jdk.handson.question.answer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllElementStartWith1 {
	public static void main(String[] args) {

		int intArr[] = { 22, 44, 33, 12, 12, 13, 181 };

		List<String> result = Arrays.stream(intArr).boxed()  // boxed is used to convert int o Integer (premitive to Wrapper)
				.map(s -> s + "")  // conver Wrapper Integer to String
				.filter(a -> a.startsWith("1"))
				.collect(Collectors.toList());
		System.out.println(result);
	}

}
