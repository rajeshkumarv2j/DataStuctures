package com.jrk.ds.hashtable.oa.linearprobing;

public class Hash {
	int hash_pos;
	int array[] = new int[40];

	public Hash() {
		for (int i = 0; i < 40; i++) {
			array[i] = '*';
		}
	}

	void insert(int data) {
		int count = 0;
		System.out.println("Enter the data to insert: ");
		hash_pos = hashCode(data);
		if (hash_pos >= 40) {
			hash_pos = 0;
		}
		while (array[hash_pos] != '*') {
			hash_pos = reHash(hash_pos);
			count++;
			if (count >= 40) {
				System.out
						.println("Memory Full!!No space is avaible for storage");
				break;
			}
		}
		if (array[hash_pos] == '*') {
			array[hash_pos] = data;
		}
		System.out.println("Data is stored at index " + hash_pos);
	}

	int hashCode(int key) {
		return key % 100;
	}

	int reHash(int key) {
		return (key + 1) % 100;
	}

	void search(int key) {
		int i;
		boolean isFound = false;
		System.out.println("Enter the key to search: ");
		for (i = 0; i < 40; i++) {
			if (array[i] == key) {
				isFound = true;
				break;
			}
		}
		if (isFound) {
			System.out.println("The key is found at index " + i);
		} else {
			System.out.println("No record found!!");
		}
	}

	void Delete(int key) {
		int i;
		boolean isFound = false;
		System.out.println("Enter the key to delete: ");
		for (i = 0; i < 40; i++) {
			if (array[i] == key) {
				isFound = true;
				break;
			}
		}
		if (isFound) {
			array[i] = '*';
			System.out.println("The key is deleted");
		} else {
			System.out.println("No key is Found!!");
		}
	}

}