package com.binarysearch;

//In Rotated binary search at first we have to find pivot element(either greatest or smallest element) and then based on pivot element we can find our target value
public class RotatedBinarySearch {

	static int finPivotGreatest(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		if (arr[end] > arr[start]) {
			return arr[end];
		}

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (mid > start && arr[mid] < arr[mid - 1]) {
				return arr[mid - 1];
			}
			if (mid < end && arr[mid] > arr[mid + 1]) {
				return arr[mid];
			}
			if (arr[start] >= arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	static int findPivotLargestWithDup(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (mid < end && arr[mid] > arr[mid + 1]) {
				return mid;
			}
			if (mid > start && arr[mid - 1] > arr[mid]) {
				return mid - 1;
			}
			if ((arr[mid] == arr[start]) && (arr[mid] == arr[end])) {
				if (arr[start] > arr[start + 1]) {
					return start;
				}
				start++;

				if (arr[end] < arr[end - 1]) {
					return end - 1;
				}
				end--;
			}

			if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
				start = mid + 1;
			} else {
				end = end - 1;
			}
		}
		return -1;
	}

	static int finPivotSmallest(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		if (arr[end] > arr[start]) {
			return arr[start];
		}

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (mid > start && arr[mid] < arr[mid - 1]) {
				return arr[mid];
			}
			if (mid < end && arr[mid] > arr[mid + 1]) {
				return arr[mid + 1];
			}
			if (arr[start] >= arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int[] arr = { 5, 6, 7, 0, 1, 2, 4 };

		System.out.println("Greatest element in array: " + finPivotGreatest(arr));
		System.out.println("smallest element in array: " + finPivotSmallest(arr));

	}

}
