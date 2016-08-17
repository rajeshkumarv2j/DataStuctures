package com.jrk.ds.allhash;

/**
 * Java program to implement Hash Table
 **/

class HashTable {
	int[] arr;
	int capacity;

	/** constructor **/
	public HashTable(int capacity) {
		this.capacity = nextPrime(capacity);
		arr = new int[this.capacity];
	}

	/** function to insert **/
	public void insert(int ele) {
		System.out.println("for " + ele + ".." + (ele % capacity));
		arr[ele % capacity] = ele;
	}

	/** function to clear **/
	public void clear() {
		arr = new int[capacity];
	}

	/** function contains **/
	public boolean contains(int ele) {
		return arr[ele % capacity] == ele;
	}

	/** function to delete **/
	public void delete(int ele) {
		if (arr[ele % capacity] == ele)
			arr[ele % capacity] = 0;
		else
			System.out.println("\nError : Element not found\n");
	}

	/** Function to generate next prime number >= n **/
	private static int nextPrime(int n) {
		if (n % 2 == 0)
			n++;
		while(!isPrime(n))
			n += 2;
		return n;
	}

	/** Function to check if given number is prime **/
	private static boolean isPrime(int n) {
		if (n == 2 || n == 3)
			return true;
		if (n == 1 || n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

	/** function to print hash table **/
	public void printTable() {
		System.out.print("\nHash Table = ");
		for (int i = 0; i < capacity; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}

/** Class HashTableTest **/
public class HashTableTest {
	public static void main(String[] args) {
		HashTable ht = new HashTable(14);
		ht.insert(12);
		ht.insert(6);
		ht.insert(4);
		ht.insert(8);
		ht.insert(19);
		ht.insert(17);
		ht.insert(112);
		ht.insert(106);
		ht.insert(105);
		ht.insert(107);
		ht.insert(104);
		ht.insert(108);
		ht.insert(109);
		ht.insert(119);
		ht.insert(117);
		System.out.println(ht.contains(6));
		ht.delete(6);
		System.out.println(ht.contains(6));
		ht.printTable();
	}
}