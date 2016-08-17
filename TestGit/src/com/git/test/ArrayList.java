package com.jrk.ds.linkedlist;

public class ArrayList<E> implements List<E> {

	private E[] array;
	private int size;
	private float loadFactor = 1.5f;

	public int size() {
		return size;
	}
	
	public ArrayList() {
		array = (E[]) new Object[10];
	}

	public ArrayList(int initialCapacity, float loadFactor) {
		array = (E[]) new Object[initialCapacity];
		this.loadFactor = loadFactor;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(int index, E e) {
		checkCapacityToAdd();
		if (index > size || index < 0)
		    throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		/*for (int i = size - 1; i > index - 1; i--) {
			array[i + 1] = array[i];
		}*/
		System.arraycopy(array, index, array, index+1, size-index);
		array[index] = e;
		++size;
	}

	private void checkCapacityToAdd() {
		// TODO Auto-generated method stub
	}

	@Override
	public void add(E e) {
		checkCapacityToAdd();
		array[size++] = e;
	}

	@Override
	public void addFirst(E e) {
		add(0, e);
	}

	@Override
	public void addAfter(E e, E after) {
		add(indexOf(after)+1, e);
	}

	@Override
	public void delete(E e) {
		int index = indexOf(e);
		delete(index);
	}

	private void delete(int index) {
		for (; index < size - 1; index++) {
			array[index] = array[index + 1];
		}
		array[index] = null;
		--size;
		checkCapacityToDelete();
	}

	private void checkCapacityToDelete() {
		// TODO Auto-generated method stub

	}

	public int indexOf(E e) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(E e) {
		for (int i = size-1; i >= 0; i--) {
			if (array[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void deleteFirst() {
		delete(0);
	}

	@Override
	public void deleteAfter(E after) {
		delete(indexOf(after) + 1);
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getHead() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		int i = 0;
		while(i< size){
				buffer.append(array[i]);
				buffer.append(++i == size?"]":", ");
		}
		return buffer.toString();
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
