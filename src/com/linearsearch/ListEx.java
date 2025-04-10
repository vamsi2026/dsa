package com.linearsearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ListEx {

	static int linearSearch(List<Integer> list, int target) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == target) {
				return list.get(i);
			}
		}

		return -1;
	}

	static String linearSearchStr(List<String> list, String target) {

		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i).toString()).equals(target)) {
				return list.get(i).toString();
			}
		}

		return "doesn't exist";
	}

	public static void main(String[] args) {

		List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 12, 34);
		List<String> strList = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

		int intTarget = 7;
		String strTarget = "cherrys";
		int intIndex = IntStream.range(0, intList.size()).filter(i -> intList.get(i) == intTarget).findFirst()
				.orElse(-1);
		int intValue = IntStream.range(0, intList.size()).map(i -> intList.get(i)).filter(value -> value == intTarget)
				.findFirst().orElse(-1);
		int intVal = intList.stream().filter(i -> i == intTarget).findFirst().orElse(-1);

		int strIndex = IntStream.range(0, strList.size()).filter(i -> strList.get(i).equals(strTarget)).findFirst()
				.orElse(-1);

		String strValue = IntStream.range(0, strList.size()).mapToObj(i -> strList.get(i))
				.filter(val -> val.equals("apple")).findFirst().orElse("doesn't exist");
		String strVal = strList.stream().filter(n -> n.equals(strTarget)).findFirst().orElse("doesn't exist");

		System.out.println("Note: If -1 displays that means value doesn't exists");
		System.out.println();
		System.out.println("Given Integer value is at index: " + intIndex);
		System.out.println("Given Integer value : " + intValue);
		System.out.println("Given Integer value: " + intVal);
		System.out.println("Given Integer value: " + linearSearch(intList, intTarget));
		System.out.println("Given String  value: " + linearSearchStr(strList, strTarget));
		System.out.println("Given String  value is at index: " + strIndex);
		System.out.println("Given String  value: " + strValue);
		System.out.println("Given String  value: " + strVal);

	}

}
