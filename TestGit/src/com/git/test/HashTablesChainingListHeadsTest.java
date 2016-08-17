package com.jrk.ds.allhash;

/*
 *    Java Program to Implement Hash Tables Chaining with List Heads
 */

/* Class LinkedHashEntry */
class LinkedHashEntry {
	String key;
	int value;
	LinkedHashEntry next;

	/* Constructor */
	LinkedHashEntry(String key, int value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}
}

/* Class HashTablesChainingListHeads */
class HashTablesChainingListHeads {
	private int TABLE_SIZE;
	private int size;
	private LinkedHashEntry[] table;

	/* Constructor */
	public HashTablesChainingListHeads(int ts) {
		size = 0;
		TABLE_SIZE = ts;
		table = new LinkedHashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	/* Function to get number of key-value pairs */
	public int getSize() {
		return size;
	}

	/* Function to clear hash table */
	public void makeEmpty() {
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	/* Function to get value of a key */
	public int get(String key) {
		int hash = (myhash(key) % TABLE_SIZE);
		if (table[hash] == null)
			return -1;
		else {
			LinkedHashEntry entry = table[hash];
			while (entry != null && !entry.key.equals(key))
				entry = entry.next;
			if (entry == null)
				return -1;
			else
				return entry.value;
		}
	}

	/* Function to insert a key value pair */
	public void insert(String key, int value) {
		int hash = (myhash(key) % TABLE_SIZE);
		if (table[hash] == null)
			table[hash] = new LinkedHashEntry(key, value);
		else {
			LinkedHashEntry entry = table[hash];
			while (entry.next != null && !entry.key.equals(key))
				entry = entry.next;
			if (entry.key.equals(key))
				entry.value = value;
			else
				entry.next = new LinkedHashEntry(key, value);
		}
		size++;
	}

	public void remove(String key) {
		int hash = (myhash(key) % TABLE_SIZE);
		if (table[hash] != null) {
			LinkedHashEntry prevEntry = null;
			LinkedHashEntry entry = table[hash];
			while (entry.next != null && !entry.key.equals(key)) {
				prevEntry = entry;
				entry = entry.next;
			}
			if (entry.key.equals(key)) {
				if (prevEntry == null)
					table[hash] = entry.next;
				else
					prevEntry.next = entry.next;
				size--;
			}
		}
	}

	/* Function myhash which gives a hash value for a given string */
	private int myhash(String x) {
		int hashVal = x.hashCode();
		hashVal %= TABLE_SIZE;
		System.out.print("\n act hc.."+x.hashCode()+" key.."+x+", hash.."+hashVal);
		if (hashVal < 0)
			hashVal += TABLE_SIZE;
		return hashVal;
	}

	/* Function to print hash table */
	public void printHashTablesChainingListHeads() {
		for (int i = 0; i < TABLE_SIZE; i++) {
			System.out.print("\nBucket " + (i + 1) + " : ");
			LinkedHashEntry entry = table[i];
			while (entry != null) {
				System.out.print(entry.value + " ");
				entry = entry.next;
			}
		}
	}
}

/* Class HashTablesChainingListHeadsTest */
public class HashTablesChainingListHeadsTest {
	public static void main(String[] args) {
		HashTablesChainingListHeads htcsll = new HashTablesChainingListHeads(10);
		htcsll.insert("1",10);
		htcsll.insert("2",15);
		htcsll.insert("3",20);
		htcsll.insert("4",25);
		htcsll.insert("5",30);
		htcsll.insert("6",35);
		htcsll.insert("7",40);
		htcsll.insert("8",45);
		htcsll.insert("9",50);
		htcsll.insert("10",55);
		htcsll.insert("11",60);
		htcsll.insert("12",65);
		htcsll.insert("13",70);
		htcsll.insert("14",75);
		htcsll.insert("15",80);
		htcsll.insert("16",85);
		htcsll.insert("17",90);
		htcsll.insert("18",95);
		htcsll.insert("19",100);
		htcsll.insert("20",105);
		htcsll.printHashTablesChainingListHeads();
		htcsll.remove("10");
		htcsll.printHashTablesChainingListHeads();
		System.out.println(htcsll.get("20"));
	}
}