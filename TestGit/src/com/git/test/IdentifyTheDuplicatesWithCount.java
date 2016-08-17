package com.jatin.ps.spoj;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class IdentifyTheDuplicatesWithCount {
	public static void main(String[] args) {
		int[] a = { 1, 1, 4, 5, 6, 6, 7, 7, 7, 8, 9, 0 };

		HashMap<Integer, Integer> dC = new HashMap<Integer, Integer>();

		// With Java
		for (int i = 0; i < a.length; i++) {
			if (dC.containsKey(a[i])) {
				Set<Entry<Integer, Integer>> entries = dC.entrySet();
				for (Entry<Integer, Integer> entry : entries) {
					if (entry.getKey() == a[i]){
						entry.setValue(entry.getValue() + 1);
						break;
					}
				}
			} else {
				dC.put(a[i], 1);
			}
		}
		
		Set<Entry<Integer, Integer>> entries = dC.entrySet();
		for (Entry<Integer, Integer> entry : entries) {
			System.out.println(entry.getKey()+"  no of times..."+entry.getValue());
		}

	}
}