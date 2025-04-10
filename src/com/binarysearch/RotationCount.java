package com.binarysearch;

public class RotationCount {

	private static int findRotationCount(int[] arr) {

		int pivot = findPivot(arr);

		return pivot + 1;
	}

	private static int findRotationCountWithDup(int[] arr) {

		int pivot = findPivotWithdup(arr);

		return pivot + 1;
	}

	private static int findPivot(int[] arr) {

		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] > arr[mid + 1]) {
				return mid;
			}
			if (arr[mid] < arr[mid - 1]) {
				return mid - 1;
			}
			if (arr[start] <= arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		return -1;

	}

	private static int findPivotWithdup(int[] arr) {

		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] > arr[mid + 1]) {
				return mid;
			}
			if (arr[mid] < arr[mid - 1]) {
				return mid - 1;
			}

			if ((arr[mid] == arr[start]) && (arr[mid] == arr[end])) {
				if (arr[start] > arr[start + 1]) {
					return arr[start];
				}
				start++;

				if (arr[end] < arr[end - 1]) {
					return arr[end - 1];
				}
				end--;
			}

			if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		return -1;

	}

	public static void main(String[] args) {

		int[] arr = { 15, 18, 2, 3, 6, 12 };

		int[] arr1 = { 15, 15, 18, 2, 3, 3, 6, 12 };

		System.out.println("Rotated:" + (findRotationCount(arr)) + "times");

		System.out.println(findRotationCountWithDup(arr1));

	}

}
