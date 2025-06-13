package com.jdk.handson.question.answer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicaesBetweenTwoString {

	public static void main(String[] args) {

		// way to declaring array
		String arr[];
		// or
		String[] arr1;
		
		String arr3[]= {"Rahul","Ajay"};

		// way to declaring and initialization of an array
		String arr2[] = new String[2];
		arr2[0] = "rahul";
		arr2[1] = "raju";

		int count = 1;
		List<String> asList = Arrays.asList("r", "a", "h", "u", "l", "r", "a", "j", "u");

		Map<String, Integer> hm = new HashMap();
		for (String s : asList) {
			if (hm.containsKey(s)) {
				hm.put(s, hm.get(s) + 1);
			} else {
				hm.put(s, count);
			}
		}
		System.out.println(hm);

		Map<String, Long> collect = "The quick brown fox jumped over the lazy dog.".chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
		
		System.out.println(collect);
	}

}
