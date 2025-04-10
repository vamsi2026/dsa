package com.binarysearch;

public class InfiniteArray {

	private static int infiniteMethod(int[] arr, int target) {

		int start = 0;
		int end = 1;

		while (end < arr.length && target > arr[end]) {

			int temp = end + 1;

			end = end + (end - start + 1) * 2;

			if (end >= arr.length) {
				end = arr.length - 1;
			}

			start = temp;
		}
		return binarySearch(start, end, target, arr);
	}

	private static int binarySearch(int start, int end, int target, int[] arr) {

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (target > arr[mid]) {
				start = mid + 1;
			} else if (target < arr[mid]) {
				end = mid - 1;
			} else if(arr[mid] == target){
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int[] arr = { 2, 3, 4, 6, 8, 9, 13, 15, 16 };

		System.out.println(infiniteMethod(arr, 17));

	}

}
