package com.jdk.handson.question.answer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FindNthHighestSalary {

	public static void main(String[] args) {

		// Sceneion -1st
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("Ankit", Double.valueOf(12000));
		map.put("Debasis", Double.valueOf(23000));
		map.put("karan", Double.valueOf(9000));
		map.put("Puran", Double.valueOf(65000));
		map.put("Pankaj", Double.valueOf(6000));
		map.put("Kames", Double.valueOf(32000));
		map.put("Giris", Double.valueOf(10000));

		Entry<String, Double> nthSalary = getNthSalary_scenerio_1(map, 3);
		System.out.println(nthSalary);

		// Scenerio -2nd
		Map<String, Double> map2 = new HashMap<String, Double>();
		map2.put("Ankit", Double.valueOf(23000));
		map2.put("Debasis", Double.valueOf(23000));
		map2.put("karan", Double.valueOf(23000));
		map2.put("Puran", Double.valueOf(23000));
		map2.put("Pankaj", Double.valueOf(32000));
		map2.put("Kames", Double.valueOf(32000));
		map2.put("Giris", Double.valueOf(10000));

	}

	public static Entry<String, Double> getNthSalary_scenerio_1(Map<String, Double> map, int num) {
		Entry<String, Double> result_1 = map.entrySet().stream()
				.sorted(Collections.reverseOrder(Entry.comparingByValue())).collect(Collectors.toList())
				.get(num - 1);

		return result_1;
	}

}
