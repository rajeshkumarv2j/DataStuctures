package com.jatin.ds.sorting;

public class InsertionSort {

	/*
	 * 9, 5, 8, 7, 6
	 * 5, 9, 8, 7, 6	1st i = 1-hole 1, value 5
	 * 5, 8, 9, 7, 6	2nd i = 2-hole 2, value 8
	 * 5, 7, 8, 9, 6	2nd i = 3-hole 3, value 7
	 * 5, 6, 7, 8, 9	2nd i = 3-hole 4, value 6
	 * 
	 * Ex:
	 * Insertion Sort:
	 * 5 4 3 2 1
	 * 4 5 3 2 1
	 * 3 4 5 2 1
	 * 2 3 4 5 1
	 * 1 2 3 4 5
	 * 
	 * Bubble Sort:
	 * 5 4 3 2 1
	 * 4 3 2 1 5
	 * 3 2 1 4 5
	 * 2 1 3 4 5
	 * 1 2 3 4 5
	 * 
	 */
	void insertionSort(int[] e) {
		for (int i = 1; i < e.length; i++) {
			int value = e[i];
			int hole = i;
			while (hole > 0 && e[hole - 1] > value) {
				e[hole] = e[hole - 1];
				hole = hole - 1;
			}
			e[hole] = value;
		}
	}

	void insertionSort1(int[] e) {
		for (int i = 1; i < e.length; i++) {
			int value = e[i];
			int j = i;
			while (j > 0 && e[j - 1] > value) {
				e[j] = e[j - 1];
				j--;
			}
			e[j] = value;
		}
	}
	
	public static void main(String[] args) {
//		 int[] a1 = {9,8,7,6,5,4,3,2,1};
//		int[] a1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		 int[] a1 = { 9, 5, 8, 7, 6, 2, 1, 3, 4 };
		new InsertionSort().insertionSort(a1);
		for (Integer integer : a1) {
			System.out.print(integer + " ");
		}
	}
}
