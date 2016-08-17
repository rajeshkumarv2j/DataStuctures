package com.jatin.ds.sorting;

import com.jrk.ds.queue.ArrayQueueImpl;
import com.jrk.ds.queue.Queue;

public class BucketSortMine {

	private Queue<Integer>[] queues;

	@SuppressWarnings("unchecked")
	public BucketSortMine() {
		queues = new Queue[10];
		for (int i = 0; i < queues.length; i++)
			queues[i] = new ArrayQueueImpl<Integer>();
	}

	private void bucketSort(Integer[] arr) {
		int max = getMax(arr);
		double n = 10;
		int divider = (int) Math.ceil((max + 1) / n);
		for (int i = 0; i < arr.length; i++) {
			int j = (int) Math.floor(arr[i] / divider);
			queues[j].enQueue(arr[i]);
		}
		int j = 0;
		for (int i = 0; i < n; i++) {
			while (!queues[i].isEmplty())
				arr[j++] = queues[i].deQueue();
		}
	}

	private int getMax(Integer[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++)
			if (max < arr[i])
				max = arr[i];
		return max;
	}

	public static void main(String[] args) {
		Integer[] a = { 100, 150, 120, 60, 50, 5, 30 };
		// Integer[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		// Integer[] a = { 1,2,3,4,5,6,7,8,9};
		new BucketSortMine().bucketSort(a);
		for (Integer integer : a) {
			System.out.print(integer + " ");
		}
	}

}
