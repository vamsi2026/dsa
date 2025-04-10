package com.binarysearch;

//Display smallest greater number of target if target doesn't exist
public class CielingEx {

	static int cielingBinarSearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (target == arr[mid]) {
				return arr[mid];
			}
			if (target > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return arr[start];
	}

	public static void main(String[] args) {

		int[] arr = { 1, 3, 6, 8, 11, 13, 15, 18, 22, 26, 29, 33, 36 };

		int target = 5;

		int val = cielingBinarSearch(arr, target);

		if (val == target) {
			System.out.println("Target is found: " + val);
		} else {
			System.out.println("Target doesn't found, the cieling number is: " + val);
		}

	}

}
