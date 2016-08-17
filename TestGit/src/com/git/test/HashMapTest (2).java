package com.jrk.ds.hashtable.ca.chaining.test;

import com.jrk.ds.hashtable.ca.chaining.HashMap;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap hashMap = new HashMap();
		hashMap.put(1, 1234);
		hashMap.put(2, 5678);
		hashMap.put(3, 101112);
		hashMap.put(3, 101112);
		
		hashMap.put(129, 12345);
		hashMap.put(130, 5678);
		hashMap.put(131, 5678);
		
		hashMap.put(257, 12345);
		hashMap.put(258, 5678);
		hashMap.put(259, 5678);
		
		System.out.println(hashMap);
	}
}