package com.jrk.ds.hashtable.oa.linearprobing.test;

import com.jrk.ds.hashtable.oa.linearprobing.HashMapLPWithoutInfiniteLoop;

public class HashMapLPTest {
	public static void main(String[] args) {
		HashMapLPWithoutInfiniteLoop hashMap = new HashMapLPWithoutInfiniteLoop();
		hashMap.put(1, 1234);
		hashMap.put(2, 5678);
		hashMap.put(129, 12345);
		hashMap.put(130, 56789);
		System.out.println(hashMap);
		System.out.println(hashMap.get(130));
	}
}