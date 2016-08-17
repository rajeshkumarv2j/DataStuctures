package com.jatin.ds.sorting;

public class BubbleSort {

	/*		
	 * 	9, 3, 2, 1, 4 
	 * 	3, 9, 2, 1, 4
	 * 	3, 2, 9, 1, 4
	 * 	3, 2, 1, 9, 4
	 * 	3, 2, 1, 4, 9
	 * 
	 * 	2, 3, 1, 4, 9
	 * 	2, 1, 3, 4, 9
	 * 
	 * 	1, 2, 3, 4, 9
	 * 	
	 * 	
	 * 	
	 * 	
	 */
	void bubbleSort(int[] e) {
		for (int i = 0; i < e.length; i++) {
			boolean flag = false;
			for (int j = 0; j < e.length - i - 1; j++) {
				if (e[j] > e[j + 1]) {
					flag = true;
					int tmp = e[j];
					e[j] = e[j + 1];
					e[j + 1] = tmp;
				}
			}
			if (flag == false)
				break;
		}
	}

	public static void main(String[] args) {
		int[] a = { 9, 3, 2, 1, 4};
		// Integer[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		// Integer[] a = { 1,2,3,4,5,6,7,8,9};
		new BubbleSort().bubbleSort(a);
		for (Integer integer : a) {
			System.out.print(integer + " ");
		}
	}
}
