package com.jrk.ds.allhash;

/*
 * Java program to implement hash table with double hashing
 */

/* Class LinkedHashEntry */
class HashEntry {
	String key;
	int value;

	/* Constructor */
	HashEntry(String key, int value) {
		this.key = key;
		this.value = value;
	}
}

/* Class DoubleHashingHashTable */
class DoubleHashingHashTable {
	private int TABLE_SIZE;
	private int size;
	private HashEntry[] table;
	private int primeSize;

	/* Constructor */
	public DoubleHashingHashTable(int ts) {
		size = 0;
		TABLE_SIZE = ts;
		table = new HashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
		primeSize = getPrime();
	}

	/* Function to get prime number less than table size for myhash2 function */
	public int getPrime() {
		for (int i = TABLE_SIZE - 1; i >= 1; i--) {
			int fact = 0;
			for (int j = 2; j <= (int) Math.sqrt(i); j++)
				if (i % j == 0)
					fact++;
			if (fact == 0)
				return i;
		}
		/* Return a prime number */
		return 3;
	}

	/* Function to get number of key-value pairs */
	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/* Function to clear hash table */
	public void makeEmpty() {
		size = 0;
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	/* Function to get value of a key */
	public int get(String key) {
		int hash1 = myhash1(key);
		int hash2 = myhash2(key);

		while (table[hash1] != null && !table[hash1].key.equals(key)) {
			hash1 += hash2;
			hash1 %= TABLE_SIZE;
		}
		return table[hash1].value;
	}

	/* Function to insert a key value pair */
	public void insert(String key, int value) {
		if (size == TABLE_SIZE) {
			System.out.println("Table full");
			return;
		}
		int hash1 = myhash1(key);
		int hash2 = myhash2(key);
		while (table[hash1] != null) {
			hash1 += hash2;
			hash1 %= TABLE_SIZE;
		}
		table[hash1] = new HashEntry(key, value);
		size++;
	}

	/* Function to remove a key */
	public void remove(String key) {
		int hash1 = myhash1(key);
		int hash2 = myhash2(key);
		while (table[hash1] != null && !table[hash1].key.equals(key)) {
			hash1 += hash2;
			hash1 %= TABLE_SIZE;
		}
		table[hash1] = null;
		size--;
	}

	/* Function myhash which gives a hash value for a given string */
	private int myhash1(String x) {
		int hashVal = x.hashCode();
		hashVal %= TABLE_SIZE;
		if (hashVal < 0)
			hashVal += TABLE_SIZE;
		return hashVal;
	}

	/* Function myhash function for double hashing */
	private int myhash2(String x) {
		int hashVal = x.hashCode();
		hashVal %= TABLE_SIZE;
		if (hashVal < 0)
			hashVal += TABLE_SIZE;
		return primeSize - hashVal % primeSize;
	}

	/* Function to print hash table */
	public void printHashTable() {
		System.out.println("\nHash Table");
		for (int i = 0; i < TABLE_SIZE; i++)
			if (table[i] != null)
				System.out.println(table[i].key + " " + table[i].value);
	}
}

/* Class DoubleHashingHashTableTest */
public class DoubleHashingHashTableTest {
	public static void main(String[] args) {
		DoubleHashingHashTable dhht = new DoubleHashingHashTable(10);
		dhht.insert("1",10);
		dhht.insert("2",15);
		dhht.insert("3",20);
		dhht.insert("4",25);
		dhht.insert("5",30);
		dhht.insert("6",35);
		dhht.insert("7",40);
		dhht.insert("8",45);
		dhht.insert("9",50);
		dhht.insert("10",55);
		dhht.insert("11",60);
		dhht.insert("12",65);
		dhht.insert("13",70);
		dhht.insert("14",75);
		dhht.insert("15",80);
		dhht.insert("16",85);
		dhht.insert("17",90);
		dhht.insert("18",95);
		dhht.insert("19",100);
		dhht.insert("20",105);
		dhht.printHashTable();
		dhht.remove("10");
		dhht.printHashTable();
		System.out.println(dhht.get("20"));
	}

}