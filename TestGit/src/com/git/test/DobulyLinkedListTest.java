package com.jrk.ds.linkedlist.test;

import com.jrk.ds.linkedlist.DoublyLinkedListImpl;
import com.jrk.ds.linkedlist.List;

public class DobulyLinkedListTest {
	
	public static void main(String[] args) {
		List<String> dll = new DoublyLinkedListImpl<String>();
		dll.addFirst("Raju1");
		dll.addFirst("Raju2");
		dll.addFirst("Raju3");
		dll.addFirst("Raju4");
		System.out.println(dll.toString());
		
		dll.addAfter("I am Here", "Raju5");
		System.out.println(dll.toString());
		
		dll.reverse();
	}
}
