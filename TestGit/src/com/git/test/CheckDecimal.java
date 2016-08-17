package com.jatin.logical.mathematicalproblems;

public class CheckDecimal {
	void convertDecimalToDigit(int n) {
		int digits[] = new int[(n + "").length()];
		int r = 0, i = 0;
		while (n > 0) {
			r = n % 10;
			digits[i] = r;
			n = n / 10;
			i++;
		}
		int result[] = new int[digits.length];
		System.out.println("Reversed No...");
		for (int y = 0; y < digits.length; y++) {
			result[y] = digits[digits.length - y - 1];
			System.out.print(digits[y]);
		}
		System.out.print("\n");
		System.out.println("Correct No...");
		for (int y = 0; y < result.length; y++) {
			System.out.print(result[y]);
		}
	}
	public static void main(String[] args) {
		CheckDecimal checkDecimal = new CheckDecimal();
		System.out.println("Given No...\n"+125);
		checkDecimal.convertDecimalToDigit(125);
		System.out.println();
		int a = 1234;
		StringBuilder s = new StringBuilder();
		while(a>0){
			s.append(a%10);
			a = a/10;
		}
		System.out.println(s.toString());
	}
}
