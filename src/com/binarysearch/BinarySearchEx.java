package com.binarysearch;

//Finding target element from given sorted array
public class BinarySearchEx {

	static int binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (target == arr[mid]) {
				return mid;
			}

			if (target > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int[] arr = { 2, 4, 6, 8, 10, 11, 13, 15, 17, 19 };
		
		System.out.println("Target at index: "+ binarySearch(arr, 15));
	}

}
