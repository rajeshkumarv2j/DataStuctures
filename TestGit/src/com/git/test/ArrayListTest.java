package com.jrk.ds.linkedlist.test;

import com.jrk.ds.linkedlist.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		System.out.println(arrayList.isEmpty());
		arrayList.add(1);
		System.out.println(arrayList.isEmpty());
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(1, 4);
		arrayList.add(2, 5);
		arrayList.add(3, 6);
		arrayList.addFirst(12);
		arrayList.addAfter(15, 12);
		arrayList.addAfter(15, 3);
		System.out.println(arrayList.indexOf(15));
		System.out.println(arrayList.lastIndexOf(15));
		System.out.println(arrayList);
		arrayList.delete(4);
		System.out.println(arrayList);
		arrayList.deleteAfter(3);
		System.out.println(arrayList);
		arrayList.deleteFirst();
		System.out.println(arrayList);
	}
}
