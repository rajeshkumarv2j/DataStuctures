package com.jatin.logical.mathematicalproblems;

/**
 * 
 * n	Factors
 * 12	{1,2,3,4,6,12}
 * 17	{1,17}
 * 36	{1,2,3,4,6,9,12,18,36}
 * 
 * Problem : identify all the factors of n??
 * Answer : 
 * DO the trail division(try all numbers 0 to n by dividing to n) to identify all the factors of n.
 * 
 * Algorithm:
 * 
 * A<-Empty list
 * for i<-1 to n
 * 		if n%i == 0
 * 			add i to list A
 * 
 * with above algorithm we can get all factors of n
 * 
 * 
 * 
 * Observations:
 * Above all factors, which are can divide the n number.
 * 1 and number it self are factors for any number
 * There are no factors greater than n/2 for any number.
 * 
 * 
 * Improved algorithm:
 * 
 * A<-{1,n}
 * for i<-2 to n/2
 * 		if n%i == 0
 * 			add i to list A
 * 
 * But time complexity is O(n).
 * 
 * 
 * Some more Observations:
 * If some number a is factor to n then n/a also factor to n.
 * Ex: if n = 36, 2 is the factor to n, so n/2(36/2) = 18 also factor to n.
 * like	wise	
 * 			2	18(n/2)
 * 			3	12(n/3)
 * 			4	9(n/4)
 * 			6	6(n/6) = sqrRoot(n)

 * So to identify the factors instead of looping up to n/2, we can stop at sqrRoot(n).
 * The result will be same. we need to consider if i is factor, n/i also factor.
 * 
 * 
 * Improved algorithm:
 * A<-empty List
 * for i=1 to sqrRoot(n)
 * 		if n%i == 0
 * 		{
 * 			add i to List A
 * 			if i != sqrRoot(n)
 * 				add n/i to List A
 * 		}
 * 	
 * Finally 
 * the Time Complexity = O(sqrRoot(n))
 * 
 * 
 * 
 * @author Jatin
 *
 */
public class FindAllFactorsOfNTrialDivision {
	void factor(int n) {
		double nSqr = (double) Math.sqrt(n);
		int[] list = new int[(int) (nSqr + 3)];
		for (int i = 1, j = 0; i <= nSqr; i++) {
			if (n % i == 0) {
				list[j++] = i;
				if (i != nSqr)
					list[j++] = n / i;
			}
		}
		for (int y = 0; y < list.length; y++)
			System.out.print(list[y] + " ");
	}

	public static void main(String[] args) {
		FindAllFactorsOfNTrialDivision factor = new FindAllFactorsOfNTrialDivision();
		factor.factor(12);
		System.out.println("\n................");
		factor.factor(36);
		System.out.println("\n................");
		factor.factor(17);
	}
}
