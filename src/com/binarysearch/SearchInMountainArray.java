package com.binarysearch;

public class SearchInMountainArray {

	private static int search(int[] arr, int target) {

		int peak = findPeak(arr);

		System.out.println(peak);

		int firstIndex = binarySearch(arr, 0, peak, target);

		if (firstIndex != -1) {
			return firstIndex;
		}

		return binarySearch(arr, peak + 1, arr.length - 1, target);

	}

	private static int binarySearch(int[] arr, int start, int end, int target) {

		boolean isAsec = arr[start] < arr[end];
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
					start = mid + 1;
				}
			}
		}
		return -1;
	}

	private static int findPeak(int[] arr) {

		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] > arr[mid + 1]) {
				end = mid;
			} else {
				start = mid + 1;
			}

		}
		return start;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 3, 1 };

		System.out.println(search(arr, 3));

	}

}
