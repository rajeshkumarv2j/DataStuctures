package com.jrk.ds.hashtable.ca.chaining;

import java.util.Arrays;

public class HashMap {
	private final static int TABLE_SIZE = 128;

	LinkedHashEntry[] table;

	public HashMap() {
		table = new LinkedHashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	public int get(int key) {
		int hash = (key % TABLE_SIZE);
		if (table[hash] == null)
			return -1;
		else {
			LinkedHashEntry entry = table[hash];
			while (entry != null && entry.getKey() != key)
				entry = entry.getNext();
			if (entry == null)
				return -1;
			else
				return entry.getValue();
		}
	}

	public void put(int key, int value) {
		int hash = (key % TABLE_SIZE);
		if (table[hash] == null)
			table[hash] = new LinkedHashEntry(key, value);
		else {
			LinkedHashEntry entry = table[hash];
			/*
			 * As some key for this hash code already exist in the list, find
			 * that key by traversing and compare both keys if same replace old
			 * value with new value. If both keys are different then add new key
			 * to linked list
			 */
			while (entry.getNext() != null && entry.getKey() != key)
				entry = entry.getNext();
			if (entry.getKey() == key)
				entry.setValue(value);
			else
				entry.setNext(new LinkedHashEntry(key, value));
		}
	}

	public void remove(int key) {
		int hash = (key % TABLE_SIZE);
		if (table[hash] != null) {
			LinkedHashEntry prevEntry = null;
			LinkedHashEntry entry = table[hash];
			while (entry.getNext() != null && entry.getKey() != key) {
				prevEntry = entry;
				entry = entry.getNext();
			}
			if (entry.getKey() == key) {
				if (prevEntry == null)
					table[hash] = entry.getNext();
				else
					prevEntry.setNext(entry.getNext());
			}
		}
	}

	@Override
	public String toString() {
		return "HashMap [table=" + Arrays.toString(table) + "]";
	}

}