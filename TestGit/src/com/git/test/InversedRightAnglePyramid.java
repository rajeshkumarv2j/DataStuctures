package com.jatin.logical.startpyramidproblems;


public class InversedRightAnglePyramid {
	public static void main(String[] args) {
		for (int j = 5; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}