package com.linearsearch;

import java.util.Arrays;
import java.util.stream.IntStream;

// FInd target element in 2D array
public class Array2D {

	static int[] finEle(int[][] arr, int target) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (target == arr[i][j]) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { -1, -1 };
	}

	public static void main(String[] args) {

		int[][] arr = { { 2, 4, 6, 7 }, { 1, 3, 5, 8 }, { 9, 11, 13, 15 } };

		int[] result = IntStream.range(0, arr.length)           // Stream over row indices (i)
				.boxed() 										// Convert int to Integer
				.flatMap(i -> IntStream.range(0, arr[i].length) // Stream over column indices(j)
				.filter(j -> arr[i][j] == 8) 					// Find target element
				.mapToObj(j -> new int[] { i, j })) 			// Convert indices to array
				.findFirst() 									// Get first occurrence
				.orElse(new int[] { -1, -1 }); 				    // Default if not found

		System.out.println(Arrays.toString(result));

		System.out.println(IntStream.range(0, arr.length).boxed()
				.flatMap(i -> IntStream.range(0, arr[i].length).filter(j -> arr[i][j] == 11).mapToObj(j -> arr[i][j]))
				.findFirst().orElse(-1));

		int[] ele = finEle(arr, 8);

		System.out.println(Arrays.toString(ele));

	}

}
