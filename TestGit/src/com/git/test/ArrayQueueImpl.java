package com.jrk.ds.queue;

public class ArrayQueueImpl<E> implements Queue<E> {

	@SuppressWarnings("unchecked")
	E[] arrQ = (E[]) new Object[10];
	int front = -1, rear = -1;

	@Override
	public void enQueue(E e) {
		if (isEmplty()) {
			++front;
		} else if (((rear+1) % arrQ.length == front)) {
			System.out.println("Queue is full! enQueue not possible.");
			return;
		}
		rear = (rear+1) % arrQ.length;
		arrQ[rear] = e;
	}

	@Override
	public E deQueue() {
		if (isEmplty()) {
			System.out.println("Queue is empty! deQueue not possible.");
			return null;
		}
		if(front == rear){
			E e = arrQ[front];
			front = rear = -1;
			return e;
		}
		return arrQ[front++];
	}

	@Override
	public boolean isEmplty() {
		if (front == -1 && rear == -1)
			return true;
		return false;
	}

	@Override
	public E front() {
		if (isEmplty()) {
			return null;
		}
		return arrQ[front];
	}
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("[");
		for (int i = front; i <= ((front <= rear) ? rear : (arrQ.length + rear))
				&& (front != -1 && rear != -1); i++) {
			buffer.append(arrQ[(i) % arrQ.length]+" ");
		}
		return buffer.toString().trim().concat("]");
	}

	@Override
	public void travarse() {
		// TODO Auto-generated method stub
		
	}
}
