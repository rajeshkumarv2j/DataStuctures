package com.jatin.logical.startpyramidproblems;

public class LeftAnglePyramid {
	public static void main(String[] args) {
		for (int j = 4; j >= 0; j--) {
			for (int i = 0; i < 5; i++) {
				if (i >= j) {
					System.out.print("*");
				} else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}