package com.linearsearch;

import java.util.Arrays;
import java.util.stream.IntStream;

// Finding target element in array
public class ArraysNumEx {

	static int linearSearch(int[] arr, int target) {

		for (int i = 0; i <= arr.length - 1; i++) {
			if (target == arr[i]) {
				return i;
			}
		}
		return -1;
	}

	static int linearSearchStreams(int[] arr, int target) {
		return IntStream.range(0, arr.length - 1).filter(i -> i == target).findFirst().orElse(-1);
	}

	public static void main(String[] args) {

		int[] arr = { 2, 4, 6, 8, 9, 10, 12, 13, 15, 16, 18 };
		int index = Arrays.stream(arr).boxed().toList().indexOf(16);
		int target = Arrays.stream(arr).filter(n -> n == 15).findFirst().orElse(-1);

		System.out.println("index at:" + index);
		System.out.println("target:" + target);
		System.out.println("Index at: " + linearSearch(arr, 18));
	}

}
