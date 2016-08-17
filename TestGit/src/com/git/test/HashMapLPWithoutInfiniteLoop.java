package com.jrk.ds.hashtable.oa.linearprobing;

import java.util.Arrays;

public class HashMapLPWithoutInfiniteLoop {
	private final static int TABLE_SIZE = 128;

	HashEntry[] table;

	public HashMapLPWithoutInfiniteLoop() {
		table = new HashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	public int get(int key) {
		int hash = (key % TABLE_SIZE);
		while (table[hash] != null && table[hash].getKey() != key)
			hash = (hash + 1) % TABLE_SIZE;
		if (table[hash] == null)
			return -1;
		else
			return table[hash].getValue();
	}

	public void put(int key, int value) {
		int hash = (key % TABLE_SIZE);
		while (table[hash] != null && table[hash].getKey() != key)
			hash = (hash + 1) % TABLE_SIZE;
		table[hash] = new HashEntry(key, value);
	}

	@Override
	public String toString() {
		return "HashMapLP [table=" + Arrays.toString(table) + "]";
	}
	
	
}