package com.jrk.ds.searching;

public class BinarySearch {

	static int findIndex(int[] values, int target) {
		return binarySearch(values, target, 0, values.length - 1);
	};

	static int binarySearch(int[] values, int target, int start, int end) {
		if (start > end) {
			return -1;
		}
		int middle = (int) Math.floor((start + end) / 2);
		int value = values[middle];

		if (value > target) {
			return binarySearch(values, target, start, middle - 1);
		}
		if (value < target) {
			return binarySearch(values, target, middle + 1, end);
		}
		return middle; // found!
	}

	public static int binarySearchItr(int[] a, int k) {
		int low = 1, high = a.length;
		do {
			int mid = (low + high) / 2;
			if (a[mid] < k)
				low = mid + 1;
			else if (a[mid] > k)
				high = mid - 1;
			else
				return mid;
		} while (low < high);
		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 4, 10, 15, 18, 24, 29, 33, 43, 55, 59, 64, 73, 73, 80, 99 };
		int y = 0;
		for (int i : a) {
			System.out.print("(" + y++ + "," + i + ")");
		}
		System.out.println("\n" + BinarySearch.findIndex(a, 99));
		System.out.println("\n" + BinarySearch.binarySearchItr(a, 99));
	}
}