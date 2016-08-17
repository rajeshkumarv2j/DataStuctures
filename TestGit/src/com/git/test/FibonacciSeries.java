package com.jatin.ds.recursion;

public class FibonacciSeries {

	
	/**
	 * FibonacciSeries 
	 * EX:	0 1 1 2 3 5 8 13 21....
	 * 
	 * @param n
	 * @return
	 */
	static int fib(int n) {
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}
	
	static int fibGood(int n) {
		if (n <= 1)
			return n;
		int f1 = 0;
		int f2 = 1;
		int f = 0;
		for (int i = 2; i <= n; i++) {
			f = f1 + f2;
			f1 = f2;
			f2 = f;
		}
		return f;
	}
	
	public static void main(String[] args) {
		System.out.println("........one");
		System.out.println(FibonacciSeries.fibGood(3));
		System.out.println("........two");
		System.out.println(FibonacciSeries.fib(3));
		System.out.println("........three");
	}
}
