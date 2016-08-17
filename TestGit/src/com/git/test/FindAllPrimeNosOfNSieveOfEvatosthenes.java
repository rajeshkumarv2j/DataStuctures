package com.jatin.logical.mathematicalproblems;

public class FindAllPrimeNosOfNSieveOfEvatosthenes {
	void primeNosList(int n) {
		int prime[] = new int[n + 1];
		for (int i = 0; i <= n; i++)
			prime[i] = 1;
		prime[0] = 0;//0 marked as prime
		prime[1] = 0;//1 marked as prime
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (prime[i] == 1) {
				for (int j = 2; i * j <= n; j++)
					prime[i * j] = 0;
				/*
				 *  for 1st time all 2 factors are marked as prime
				 *  i.e. 2*2, 2*3, 2*4, 2*5, 2*6.... 2*n
				 *  for 1st time all 3 factors are marked as prime
				 *  i.e. 3*2, 3*3, 3*4, 3*5, 3*6.... 3*n
				 */
			}
		}
	}

	/**
	 * Time Complexity of below algorithm: O(sqrRoot(n))
	 * 
	 * @param n
	 * @return
	 */
	static boolean isprimeNo(int n) {
		boolean flag = true;
		double nSqrt = Math.sqrt(n);
		for (int i = 2; i <= nSqrt; i++) {
			if (n % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * So Time complexity of this method id n*sqrRoot(n)
	 * @param n
	 */
	static void fetchPrimeNos(int n) {
		for (int i = 2; i <= n; i++) {
			System.out.print(isprimeNo(i) ? i + "," : "");
		}
	}

	public static void main(String[] args) {
		FindAllPrimeNosOfNSieveOfEvatosthenes.fetchPrimeNos(10);
	}
}
