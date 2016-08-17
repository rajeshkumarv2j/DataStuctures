package com.jrk.ds.searching.pattern;

import java.util.Scanner;

public class AnagramSubstringSearch {
	public static final int MAX = 256;

	static boolean compare(char arr1[], char arr2[]) {
		for (int i = 0; i < MAX; i++)
			if (arr1[i] != arr2[i])
				return false;
		return true;
	}

	static void search(char[] pat, char[] txt) {
		int M = pat.length, N = txt.length;

		// countP[]: Store count of all characters of pattern
		// countTW[]: Store count of current window of text
		char countP[] = new char[MAX];
		char countTW[] = new char[MAX];
		for (int i = 0; i < M; i++) {
			(countP[pat[i]])++;
			(countTW[txt[i]])++;
		}

		// Traverse through remaining characters of pattern
		for (int i = M; i < N; i++) {
			// Compare counts of current window of text with
			// counts of pattern[]
			if (compare(countP, countTW))
				System.out.println("Found at Index " + (i - M));

			// Add current character to current window
			(countTW[txt[i]])++;

			// Remove the first character of previous window
			countTW[txt[i - M]]--;
		}

		// Check for the last window in text
		if (compare(countP, countTW))
			System.out.println("Found at Index " + (N - M));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the no of test cases...");
		int testcases = scanner.nextInt();
		String[] texts = new String[testcases];
		String[] words = new String[testcases];

		for (int i = 0; i < testcases; i++) {
			System.out.println("Enter the Text for Test case : " + (i+1));
			texts[i] = scanner.next();
			System.out.println("Enter the Word for Test case : " + (i+1));
			words[i] = scanner.next();
		}

		for (int i = 0; i < testcases; i++) {
			search(words[i].toCharArray(), texts[i].toCharArray());

			// This function returns true if contents of arr1[] and arr2[]
			// are same, otherwise false.

			// This function search for all permutations of pat[] in txt[]

			/* Driver program to test above function */
		}
	}
}
