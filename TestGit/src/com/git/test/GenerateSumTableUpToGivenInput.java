package com.jatin.logical.mathematicalproblems;

public class GenerateSumTableUpToGivenInput {
	public static void main(String[] args) {
		int ip = 4;
		int k = 1;
		for (int j = 0; j < ip; j++) {
			if (j % 2 == 0) {
				for (int i = 0; i < ip; i++) {
					System.out.print((i + k) + "\t");
				}
			} else {
				for (int i = ip-1; i >= 0; i--) {
					System.out.print((i + k) + "\t");
				}
			}
			k = k + ip;
			System.out.println();
		}
	}
}