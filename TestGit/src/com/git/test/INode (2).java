package com.jrk.ds.linkedlist;

public interface INode<E>{
	E getData();
	INode<E> getNext();
	INode<E> getPrev();
}
