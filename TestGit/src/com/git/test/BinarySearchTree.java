package com.jatin.ds.binarysearchtree;

import com.jatin.ds.binarysearchtree.BinarySearchTreeLinkedListImpl.BSTNode;
import com.jatin.ds.binarysearchtree.BinarySearchTreeLinkedListImpl.Node;

public interface BinarySearchTree<E> {

	Node<E> insert(Node<E> tree, E e);
	boolean search(Node<E> tree, E e);
	E findMin(Node<E> tree);
	E findMax(Node<E> tree);
	E findHeight(BSTNode root);
	E findHeight(Node<E> tree);
	E findDeapth(Node<E> tree);
	void levelOrderTraversal(Node<E> tree);
	void preOrderDeapthFirstTraversal(Node<E> tree);
	void inOrderDeapthFirstTraversal(Node<E> tree);
	void postOrderDeapthFirstTraversal(Node<E> tree);
	boolean isBinarySearchTree(Node<E> tree);
	boolean isBst(Node<E> tree);
	Node<E> deleteElement(Node<E> tree, E e);

	void insertWithoutRecursion(E e);
	boolean searchWithoutRecursion(E e);
	E findMinWithoutRecursion();
	E findMaxWithoutRecursion();
	void levelOrderTraversalWithArray();
	boolean isBinarySearchTree(BSTNode<E> tree);
	int sizeOfTree(BSTNode<E> root);
	BSTNode<E> getInOrderSuccessor(BSTNode<E> tree, E e);
	BSTNode<E> getInOrderPredecessor(BSTNode<E> root, E e);
}
