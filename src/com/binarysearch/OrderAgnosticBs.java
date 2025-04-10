package com.binarysearch;

public class OrderAgnosticBs {

	private static int search(int[] arr, int target) {

		boolean isAsec = false;
		int start = 0;
		int end = arr.length - 1;

		if (arr[start] < arr[end]) {
			isAsec = true;
		}

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			if (isAsec) {
				if (target > arr[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				if (target > arr[mid]) {
					end = mid - 1;
				} else {
					start = start + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int[] arr = { 54, 43, 32, 21, 10, 8, 6, 4, 2 };

		int[] arr1 = { 2, 4, 6, 8, 9, 11, 14, 16, 18 };

		System.out.println(search(arr1, 4));

	}

}
