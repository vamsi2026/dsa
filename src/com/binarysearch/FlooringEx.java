package com.binarysearch;

//Display greatest small number than target if target doesn't exist
public class FlooringEx {

	static int flooringBinarySearch(int[] arr, int target) {
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
		return arr[end];
	}

	public static void main(String[] args) {
		int[] arr = {1,4,8,12,16,19,22,26,28,33,36};
		int target = 21;
		int flooringBinarySearch = flooringBinarySearch(arr, target);
		
		if(target == flooringBinarySearch) {
			System.out.println("Target is found: "+ flooringBinarySearch);
		}else {
			System.out.println("Target doesn't exists, so the flooring number is at index: "+ flooringBinarySearch);
		}

	}

}
