package com.jatin.logical.startpyramidproblems;

public class DimondPyramid {
	public static void main(String[] args) {
		int nR = 5;
		int r, cs, s;
		for (r = 1; r < nR; r++) {
			for (cs = nR - r; cs >= 1; cs--) {
				System.out.print(" ");
			}
			for (s = 1; s <= (r * 2) - 1; s++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (r = nR; r >= 1; r--) {
			for (cs = nR - r; cs >= 1; cs--) {
				System.out.print(" ");
			}
			for (s = 1; s <= (r * 2) - 1; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}