package com.jrk.ds.searching;

public class LinearSearch {

	public static int findIndex(int[] values, int target) {
		for (int i = 0; i < values.length; ++i) {
			if (values[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int i[] = {9,5,8,2,7,1,6,10,12,5};
		System.out.println("index..."+LinearSearch.findIndex(i, 12));
		System.out.println("value..."+i[LinearSearch.findIndex(i, 12)]);
	}
}
