package com.jatin.ds.recursion;

public class Expoenetioal {
	int powerRecursive(int x, int n) {
		if (n == 0)
			return 1;
		return x * powerRecursive(x, n - 1);
	}

	int powerRecursive1(int x, int n) {
		if (n == 0)
			return 1;
		if (n % 2 == 0) {
			int y = powerRecursive1(x, n/2);
			return y * y;
		}
		return x * powerRecursive1(x, n - 1);
	}

	int powerIterative(int x, int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = result * x;
		}
		return result;
	}

	public static void main(String[] args) {
		Expoenetioal power = new Expoenetioal();
		int x = 2;
		int n = 3000;
		System.out.println(power.powerIterative(x, n));
		System.out.println(power.powerRecursive(x, n));
		System.out.println(power.powerRecursive1(x, n));
	}
}
