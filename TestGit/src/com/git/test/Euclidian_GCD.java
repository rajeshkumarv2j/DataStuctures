package com.jatin.logical.mathematicalproblems;

public class Euclidian_GCD {

	/**
	 * 
	 * <p>
	 * LCM of 8,12 = 2 (2*2 = 8 and 2*6 = 12 so 2 is Least common multiple. To
	 * identify LCM start with 2)
	 * </p>
	 * <p>
	 * GCD of 8,12 = 4 (4*2 = 8 and 4*3 = 12 so 4 is Greatest common divisor of
	 * 8 and 12. To identify GCD start with minimum of 2 input values )
	 * </p>
	 * 
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	int euclidian_gcd(int x, int y) {
		int num = x >= y ? x : y;
		int den = x <= y ? x : y;
		while (den != 0) {
			int rem = num % den;
			num = den;
			den = rem;
		}
		return num;
	}

	/*
	 * After code optimization
	 */
	int e_gcd(int x, int y) {
		return y == 0 ? x : e_gcd(y, x % y);
	}

	public static void main(String[] args) {
		Euclidian_GCD euclidian_GCD = new Euclidian_GCD();
		System.out.println(euclidian_GCD.euclidian_gcd(8, 12));
		System.out.println(euclidian_GCD.euclidian_gcd(10, 45));
		System.out.println(euclidian_GCD.euclidian_gcd(1701, 3768));
		System.out.println(euclidian_GCD.e_gcd(3768, 1701));
	}
}
