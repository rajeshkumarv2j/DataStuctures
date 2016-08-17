package com.jrk.ds.stack;

import java.util.Arrays;

public class ArrayStackImpl<E> implements Stack<E> {
	private int capacityIncrement;
	
	
	E[] array;
	int top = -1;

	public ArrayStackImpl() {
		this(10);
	}

	public ArrayStackImpl(int initialCapacity) {
		this(initialCapacity, 0);
	}

	@SuppressWarnings("unchecked")
	public ArrayStackImpl(int initialCapacity, int capacityIncrement) {
		if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
		this.array = (E[]) new Object[initialCapacity];
		this.capacityIncrement = capacityIncrement;
	}

	@Override
	public void push(E e) {
		ensureCapacityHelper(top + 1);
		array[++top] = e;
	}

	private void ensureCapacityHelper(int minCapacity) {
		int oldCapacity = array.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = (capacityIncrement > 0) ? (oldCapacity + capacityIncrement) : (oldCapacity * 2);
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			array = Arrays.copyOf(array, newCapacity);
		}
	}
	
	@Override
	public E pop() {
		if (isEmpty()) {
			System.out.println("Array Stack Under Flow");
			return null;
		}
		return array[top--];
	}

	@Override
	public E top() {
		if (isEmpty()) {
			System.out.println("Array Stack Under Flow");
			return null;
		}
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("[");
		for (int i = 0; i <= top; i++) {
			buffer.append(array[i] + " ");
		}
		return buffer.toString().trim().concat("]");
	}

	@Override
	public void reverse() {
		@SuppressWarnings("unchecked")
		E[] newArray = (E[]) new Object[capacityIncrement];
		int noOfElements = top;
		for (int i = 0; i <= noOfElements; i++) {
			newArray[i] = pop();
		}
		top = noOfElements;
		array = newArray;
	}
}
