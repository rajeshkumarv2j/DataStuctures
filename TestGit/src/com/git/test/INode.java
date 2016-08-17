package com.jrk.ds.stack;

public interface INode<E>{
	E getData();
	INode<E> getNext();
	INode<E> getPrev();
}
