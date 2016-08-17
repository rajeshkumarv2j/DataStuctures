package com.jrk.ds.allhash;

/*
 *    Java Program to Implement Hash Tables Chaining with Doubly Linked Lists 
 */

/* Node for doubly linked list */
class DLLNode {
	DLLNode next, prev;
	int data;

	/* Constructor */
	public DLLNode(int x) {
		data = x;
		next = null;
		prev = null;
	}
}

/* Class HashTableChainingDoublyLinkedList */
class HashTableChainingDoublyLinkedList {
	private DLLNode[] table;
	private int size;

	/* Constructor */
	public HashTableChainingDoublyLinkedList(int tableSize) {
		table = new DLLNode[nextPrime(tableSize)];
		size = 0;
	}

	/* Function to check if hash table is empty */
	public boolean isEmpty() {
		return size == 0;
	}

	/* Function to clear hash table */
	public void makeEmpty() {
		int l = table.length;
		table = new DLLNode[l];
		size = 0;
	}

	/* Function to get size */
	public int getSize() {
		return size;
	}

	/* Function to insert an element */
	public void insert(int val) {
		size++;
		int pos = myhash(val);
		DLLNode nptr = new DLLNode(val);
		DLLNode start = table[pos];
		if (table[pos] == null)
			table[pos] = nptr;
		else {
			nptr.next = start;
			start.prev = nptr;
			table[pos] = nptr;
		}
	}

	/* Function to remove an element */
	public void remove(int val) {
		try {
			int pos = myhash(val);
			DLLNode start = table[pos];
			DLLNode end = start;
			if (start.data == val) {
				size--;
				if (start.next == null) {
					table[pos] = null;
					return;
				}
				start = start.next;
				start.prev = null;
				table[pos] = start;
				return;
			}

			while (end.next != null && end.next.data != val)
				end = end.next;
			if (end.next == null) {
				System.out.println("\nElement not found\n");
				return;
			}
			size--;
			if (end.next.next == null) {
				end.next = null;
				return;
			}
			end.next.next.prev = end;
			end.next = end.next.next;

			table[pos] = start;
		} catch (Exception e) {
			System.out.println("\nElement not found\n");
		}
	}

	/* Function myhash */
	private int myhash(Integer x) {
		int hashVal = x.hashCode();
		hashVal %= table.length;
		if (hashVal < 0)
			hashVal += table.length;
		return hashVal;
	}

	/* Function to generate next prime number >= n */
	private static int nextPrime(int n) {
		if (n % 2 == 0)
			n++;
		for (; !isPrime(n); n += 2)
			;

		return n;
	}

	/* Function to check if given number is prime */
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

	/* Function to print hash table */
	public void printHashTable() {
		System.out.println();
		for (int i = 0; i < table.length; i++) {
			System.out.print("Bucket " + i + ":  ");

			DLLNode start = table[i];
			while (start != null) {
				System.out.print(start.data + " ");
				start = start.next;
			}
			System.out.println();
		}
	}

}

/* Class HashTableChainingDoublyLinkedListTest */
public class HashTableChainingDoublyLinkedListTest {
	public static void main(String[] args) {
		HashTableChainingDoublyLinkedList htcdll = new HashTableChainingDoublyLinkedList(10);
		htcdll.insert(55);
		htcdll.insert(60);
		htcdll.insert(50);
		htcdll.insert(65);
		htcdll.insert(70);
		htcdll.insert(45);
		htcdll.insert(75);
		htcdll.insert(40);
		htcdll.insert(80);
		htcdll.insert(35);
		htcdll.insert(85);
		htcdll.insert(30);
		htcdll.insert(90);
		htcdll.insert(25);
		htcdll.insert(95);
		htcdll.insert(20);
		htcdll.insert(100);
		htcdll.insert(15);
		htcdll.insert(105);
		htcdll.insert(10);
		htcdll.printHashTable();
		htcdll.remove(85);
		htcdll.printHashTable();
	}
}