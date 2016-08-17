package com.jrk.ds.linkedlist;


public class DoublyLinkedListImpl<E> extends AbstractList<E> implements List<E>{
	Node<E> head;
	Node<E> tail;
	
	public static class Node<E> implements INode<E> {
		E data;
		Node<E> next;
		Node<E> prev;

		public Node(E data) {
			this.data = data;
		}

		@Override
		public E getData() {
			return data;
		}

		@Override
		public INode<E> getNext() {
			return next;
		}

		@Override
		public INode<E> getPrev() {
			return prev;
		}
	}

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFirst(E e) {
		if(head == null)
			tail = head = new Node<E>(e);
		else{
			Node<E> tmp = new Node<E>(e);
			tmp.next = head;
			head.prev = tmp;
			head = tmp;
		}
	}

	@Override
	public void addAfter(E e, E after) {
		Node<E> tmp = head;
		Node<E> newOne = new Node<E>(e);
		while(true){
			if(tmp == null){
				System.out.println("Given element not exist in the list");
				break;
			}
			if(tmp.data == after){
				newOne.prev = tmp;
				newOne.next = tmp.next;
				tmp.next = newOne;
				if(newOne.next==null)
					tail = newOne;
				else
					newOne.next.prev = newOne;
				break;
			}
			tmp = tmp.next;
		}
	}

	@Override
	public void delete(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFirst() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAfter(E after) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reverse() {
		Node<E> tmp = head;
		while(tmp.next!=null){
			tmp = tmp.next;
		}
		while(tmp!=null){
			System.out.println(tmp.data);
			tmp = tmp.prev;
		}
	}

	@Override
	public INode<E> getHead() {
		return head;
	}
	
	public static void main(String[] args) {
		int[] a = new int[100];
		System.out.println(a.length);
	}

	@Override
	public void reverseRecursionChange(INode<E> node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reverseRecursionPrint(INode<E> node) {
		// TODO Auto-generated method stub
		
	}
}
