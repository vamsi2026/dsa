package com.binarysearch;

import java.util.Arrays;

public class FirstAndLastIndicesEx {

	private static int[] findFirstAndLastIndices(int[] arr, int target) {

		int[] ans = { -1, -1 };

		ans[0] = binarySearch(arr, target, true);

		if (arr[0] != -1) {
			ans[1] = binarySearch(arr, target, false);
		}
		return ans;
	}

	private static int binarySearch(int[] arr, int target, boolean findFirstIndex) {
		int ans = 0;
		int start = 0;
		int end = arr.length;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (target > arr[mid]) {
				start = mid + 1;
			} else if (target < arr[mid]) {
				end = mid - 1;
			}

			if (arr[mid] == target) {
				ans = mid;
				if (findFirstIndex) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {

		int[] arr = { 2, 3, 4, 6, 6, 6, 8, 9, 10 };

		System.out.println(Arrays.toString(findFirstAndLastIndices(arr, 6)));

	}

}
