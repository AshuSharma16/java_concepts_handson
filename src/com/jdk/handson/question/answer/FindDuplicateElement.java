package com.jdk.handson.question.answer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElement {

	public static void main(String[] args) {
		String str = "ilovejavatechie";

		String[] strArray = str.split("");

		Map<String, Long> map = Arrays.stream(strArray)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);

		List<String> collect = map.entrySet().stream().filter(a -> a.getValue() > 1).map( b -> b.getKey())
				.collect(Collectors.toList());
		System.out.println(collect);

		List<String> elementList =
				Arrays.asList("Ashu", "Bittoo", "Vritika", "Vartu", "Preeti", "Ashu", "Bittoo");

		List<String> duplicateElemnt = elementList.stream().distinct().collect(Collectors.toList());
		System.out.println("---------------");
		System.out.println("Duplicate Elemnt : "+ duplicateElemnt);

	}

}
