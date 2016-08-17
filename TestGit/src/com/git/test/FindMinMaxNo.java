package com.jatin.logical.mathematicalproblems;

import java.util.Arrays;

public class FindMinMaxNo {
	public static void main(String[] args) {
		int array[] = {10,2, 4 ,5, 50, 30};
		System.out.println("In Java"+findMaxWithCollection(array));
		System.out.println("In Java"+findMaxWithoutCollection(array));
		
		System.out.println("In Java"+findMinWithCollection(array));
		System.out.println("In Java"+findMinWithoutCollection(array));
	}

	private static int findMaxWithCollection(int[] array) {
		Arrays.sort(array);
		return array[array.length-1];
	}
	
	private static int findMaxWithoutCollection(int[] array) {
		int mx=0;
		for(int i=0; i<array.length; i++)
				mx = array[i]>mx?array[i]:mx;
		return mx;
	}

	private static int findMinWithCollection(int[] array) {
		Arrays.sort(array);
		return array[0];
	}
	
	private static int findMinWithoutCollection(int[] array) {
		int mn=array[0];
		for(int i=0; i<array.length; i++)
				mn = array[i]<mn?array[i]:mn;
		return mn;
	}
}