package com.jrk.ds.allhash;

/**
 *   Java Program to implement Linear Probing Hash Table
 **/


/** Class LinearProbingHashTable **/
class LinearProbingHashTable {
	private int currentSize, maxSize;
	private String[] keys;
	private String[] vals;

	/** Constructor **/
	public LinearProbingHashTable(int capacity) {
		currentSize = 0;
		maxSize = capacity;
		keys = new String[maxSize];
		vals = new String[maxSize];
	}

	/** Function to clear hash table **/
	public void makeEmpty() {
		currentSize = 0;
		keys = new String[maxSize];
		vals = new String[maxSize];
	}

	/** Function to get size of hash table **/
	public int getSize() {
		return currentSize;
	}

	/** Function to check if hash table is full **/
	public boolean isFull() {
		return currentSize == maxSize;
	}

	/** Function to check if hash table is empty **/
	public boolean isEmpty() {
		return getSize() == 0;
	}

	/** Fucntion to check if hash table contains a key **/
	public boolean contains(String key) {
		return get(key) != null;
	}

	/** Functiont to get hash code of a given key **/
	private int hash(String key) {
		System.out.print("\n key.."+key+" hashcode.."+key.hashCode()+" hash.."+key.hashCode() % maxSize);
		return key.hashCode() % maxSize;
	}

	/** Function to insert key-value pair **/
	public void insert(String key, String val) {
		int tmp = hash(key);
		int i = tmp;
		do {
			if (keys[i] == null) {
				keys[i] = key;
				vals[i] = val;
				currentSize++;
				return;
			}
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
			System.out.print("\n hash+1.."+(i+1)+" (key + 1) % maxSize.."+(i + 1) % maxSize);
			i = (i + 1) % maxSize;
		} while (i != tmp);
	}

	/** Function to get value for a given key **/
	public String get(String key) {
		int i = hash(key);
		while (keys[i] != null) {
			if (keys[i].equals(key))
				return vals[i];
			i = (i + 1) % maxSize;
		}
		return null;
	}

	/** Function to remove key and its value **/
	public void remove(String key) {
		if (!contains(key))
			return;

		/** find position key and delete **/
		int i = hash(key);
		while (!key.equals(keys[i]))
			i = (i + 1) % maxSize;
		keys[i] = vals[i] = null;

		/** rehash all keys **/
		for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize) {
			String tmp1 = keys[i], tmp2 = vals[i];
			keys[i] = vals[i] = null;
			currentSize--;
			insert(tmp1, tmp2);
		}
		currentSize--;
	}

	/** Function to print HashTable **/
	public void printHashTable() {
		System.out.println("\nHash Table: ");
		for (int i = 0; i < maxSize; i++)
			if (keys[i] != null)
				System.out.println(keys[i] + " " + vals[i]);
		System.out.println();
	}
}

/** Class LinearProbingHashTableTest **/
public class LinearProbingHashTableTest {

	public static void main(String[] args) {
		LinearProbingHashTable lpht = new LinearProbingHashTable(10);
		lpht.insert("1","10");
		lpht.insert("2","15");
		lpht.insert("3","20");
		lpht.insert("4","25");
		lpht.insert("5","30");
		lpht.insert("6","35");
		lpht.insert("7","40");
		lpht.insert("8","45");
		lpht.insert("9","50");
		lpht.insert("10","55");
		lpht.insert("11","60");
		lpht.insert("12","65");
		lpht.insert("13","70");
		lpht.insert("14","75");
		lpht.insert("15","80");
		lpht.insert("16","85");
		lpht.insert("17","90");
		lpht.insert("18","95");
		lpht.insert("19","100");
		lpht.insert("20","105");
		lpht.printHashTable();
		lpht.remove("10");
		lpht.printHashTable();
		System.out.println(lpht.get("20"));
	}

}