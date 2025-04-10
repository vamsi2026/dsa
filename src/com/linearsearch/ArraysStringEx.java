package com.linearsearch;

import java.util.Arrays;
import java.util.stream.IntStream;

//Find target string in array
public class ArraysStringEx {

	static String finTargetString(String[] arr, String target) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(target)) {
				return arr[i];
			}
		}
		return "Value not found";
	}

	public static void main(String[] args) {
		String[] arr = { "apple", "banana", "cherry", "date", "elderberry" };

		String value = Arrays.stream(arr).filter(n -> n == "cherryy").findFirst().orElse("No string exists");
		Integer index = IntStream.range(0, arr.length - 1).boxed().filter(i -> arr[i].equals("cherry")).findFirst()
				.orElse(-1);

		System.out.println("Given value is: " + value);
		System.out.println("Given value is at index: " + index);
		System.out.println("Given value is: " +finTargetString(arr, "cherry"));
	}

}
