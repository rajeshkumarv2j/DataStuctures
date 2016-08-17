package com.jatin.ds.recursion;

public class Factorial {
	static int factorial(int n) {
		return n == 0?1:n * factorial(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(factorial(6));
		System.out.println(factorial1(6));
	}

	static int factorial1(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = +result * i;
		}
		return result;
	}
}
