package com.jrk.ds.queue;

public class LinkedListQueueImpl<E> implements Queue<E>{

	Node<E> front;
	Node<E> rear;
	
	@Override
	public void enQueue(E e) {
		if(isEmplty()){
			front = rear = new Node<E>(e);
			return;
		}
		rear = rear.next = new Node<E>(e);
	}

	@Override
	public E deQueue() {
		if(isEmplty()){
			System.out.println("Queue is empty! You cant deQueue elements");
			return null;
		}
		Node<E> tmp = front;
		if(front.next == null){
			front = rear = null;
		}else{
			front = front.next;
			tmp.next = null;
		}
		return tmp.e;
	}

	@Override
	public boolean isEmplty() {
		return front == null && rear == null;
	}

	@Override
	public E front() {
		if(isEmplty()){
			System.out.println("Queue is empty! U cant perform front operation");
			return null;
		}
		return front.e;
	}
	public void travarse(){
		Node<E> tmp = front;
		while(true){
			if(tmp == null)
				break;
			System.out.print(tmp.e+" ");
			tmp = tmp.next;
		}
	}
	static class Node<E>{
		E e;
		Node<E> next;
		Node(E e){
			this.e = e;
		}
	}

}
