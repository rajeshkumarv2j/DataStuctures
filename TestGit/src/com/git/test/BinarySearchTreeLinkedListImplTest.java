package com.jatin.ds.binarysearchtree.test;

import com.jatin.ds.binarysearchtree.BinarySearchTree;
import com.jatin.ds.binarysearchtree.BinarySearchTreeLinkedListImpl;
import com.jatin.ds.binarysearchtree.BinarySearchTreeLinkedListImpl.Node;

public class BinarySearchTreeLinkedListImplTest {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTreeLinkedListImpl<Integer>();
		bst.insertWithoutRecursion(15);
		bst.insertWithoutRecursion(10);
		bst.insertWithoutRecursion(20);
		bst.insertWithoutRecursion(8);
		bst.insertWithoutRecursion(12);
		bst.insertWithoutRecursion(17);
		bst.insertWithoutRecursion(25);
		bst.insertWithoutRecursion(6);
		bst.insertWithoutRecursion(17);
		bst.insertWithoutRecursion(16);
		bst.insertWithoutRecursion(27);
		/*bst.insertWithoutRecursion(6);
		bst.insertWithoutRecursion(5);
		bst.insertWithoutRecursion(4);
		bst.insertWithoutRecursion(3);
		bst.insertWithoutRecursion(2);
		bst.insertWithoutRecursion(1);*/
		System.out.println(bst.getInOrderSuccessor(((BinarySearchTreeLinkedListImpl)bst).root, 12));
//		System.out.println(bst.getInOrderPredecessor(((BinarySearchTreeLinkedListImpl)bst).root, 3));
//		System.out.println(bst.isBinarySearchTree(((BinarySearchTreeLinkedListImpl)bst).root));
//		System.out.println(bst.sizeOfTree(((BinarySearchTreeLinkedListImpl)bst).root));
//		System.out.println(bst.findHeight(((BinarySearchTreeLinkedListImpl)bst).root));
		/*		System.out.println(bst.searchWithoutRecursion(1));
		System.out.println(bst.findMinWithoutRecursion());
		System.out.println(bst.findMaxWithoutRecursion());*/
//		bst.levelOrderTraversalWithArray();
	}
	
	public static void main1(String[] args) {
		Node<Integer> tree = null;
		BinarySearchTree<Integer> bst = new BinarySearchTreeLinkedListImpl<Integer>();
		/*tree = bst.insert(tree, 4);
		tree = bst.insert(tree, 1);
		tree = bst.insert(tree, 5);
		tree = bst.insert(tree, 2);
		tree = bst.insert(tree, 6);
		tree = bst.insert(tree, 3);
		tree = bst.insert(tree, 25);*/
		tree = bst.insert(tree, 5);
		tree = bst.insert(tree, 12);
		tree = bst.insert(tree, 11);
		tree = bst.insert(tree, 10);
		tree = bst.insert(tree, 7);
		tree = bst.insert(tree, 9);
		System.out.println(bst.findDeapth(tree));
		System.out.println(bst.isBst(tree));
		
		
		
		
		
		
		
		
		
		/*tree = bst.insert(tree, 15);
		tree = bst.insert(tree, 20);
		tree = bst.insert(tree, 8);
		tree = bst.insert(tree, 12);
		tree = bst.insert(tree, 20);
		tree = bst.insert(tree, 17);
		tree = bst.insert(tree, 25);
		tree = bst.insert(tree, 16);
//		tree = bst.insert(tree, 1);
//		tree = bst.insert(tree, 2);
		tree = bst.insert(tree, 3);
		
		System.out.println(bst.findMin(tree));
		System.out.println(bst.search(tree, 25)?"Found..":"Not Found..");
		System.out.println(bst.findMax(tree));
		System.out.println(bst.findHeight(tree));
		bst.levelOrderTraversal(tree);
		System.out.println();
		bst.inOrderDeapthFirstTraversal(tree);
		System.out.println();
		bst.preOrderDeapthFirstTraversal(tree);
		System.out.println();
		bst.postOrderDeapthFirstTraversal(tree);
		System.out.println();
		
		
		System.out.println(bst.isBinarySearchTree(tree));
		
		
		bst.deleteElement(tree, 3);*/
	}
}
