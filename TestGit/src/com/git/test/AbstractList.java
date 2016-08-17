package com.jrk.ds.linkedlist;

public abstract class AbstractList<E> {
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("[");
		INode<E> tmp = getHead();
		while (true) {
			if (tmp == null) {
				break;
			} else {
				buffer.append(tmp.getData() + " ");
				tmp = (INode<E>) tmp.getNext();
			}
		}
		return buffer.toString().trim().concat("]");
	}

	public abstract INode<E> getHead();
}
