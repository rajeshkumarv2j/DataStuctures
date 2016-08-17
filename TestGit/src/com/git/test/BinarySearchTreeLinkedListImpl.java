package com.jatin.ds.binarysearchtree;

import com.jrk.ds.queue.LinkedListQueueImpl;
import com.jrk.ds.queue.Queue;

public class BinarySearchTreeLinkedListImpl<E> implements BinarySearchTree<E> {

	
//	This variable mailny 
	public BSTNode<E> root;

	@Override
	public BSTNode<E> getInOrderPredecessor(BSTNode<E> root, E e){
		if(root == null)return null;
		BSTNode<E> current = findNode(root, e);
		
//		Case 1: if current node has left sub tree then the most right node will be predecessor
		if(current.left!=null){
			BSTNode<E> tmp = current.left;
			while(tmp.right!=null){
				tmp = tmp.right;
			}
			return tmp;
		}
		
//		Case 2: If current node has no left sub tree then The lowest ancestor will be predecessor
		BSTNode<E> predecessor = null;
		BSTNode<E> ancestor = root;
		while(ancestor!=current){
			if(e(ancestor.e)<e(current.e)){
				predecessor = ancestor;
				ancestor = ancestor.right;
			}else{
				ancestor = ancestor.left;
			}
		}
		return predecessor;
	}
	
	@Override
	public int sizeOfTree(BSTNode<E> root){
		if(root == null) return 0;
		return sizeOfTree(root.left) + 1 + sizeOfTree(root.right);
	}
	
	@Override
	public void insertWithoutRecursion(E e){
		if(root==null){
			root = new BSTNode<E>(e);
			return;
		}
		BSTNode<E> tmp = root;
		while(true){
			if(e(e) <= e(tmp.e)){
				if(tmp.left==null){
					tmp.left = new BSTNode<E>(e);
					return;
				}
				tmp = tmp.left;
			}else
			if(e(e) > e(tmp.e)){
				if(tmp.right==null){
					tmp.right = new BSTNode<E>(e);
					return;
				}
				tmp = tmp.right;
			}
		}
	}
	
	@Override
	public boolean searchWithoutRecursion(E e){
		if(root==null)
			return false;
		if(e(root.e) == e(e))
			return true;
		
		BSTNode<E> tmp = root;
		while(true){
			if(e(e) <= e(tmp.e)){
				if(tmp.left==null)
					return false;
				if(e(tmp.left.e) == e(e))
					return true;
				tmp = tmp.left;
			}else
			if(e(e) > e(tmp.e)){
				if(tmp.right==null)
					return false;
				if(e(tmp.right.e) == e(e))
					return true;
				tmp = tmp.right;
			}
		}
	}
	
	@Override
	public E findMinWithoutRecursion(){
		if(root == null)
			return null;
		BSTNode<E> tmp = root;
		while(tmp.left!=null){
			tmp = tmp.left;
		}
		return tmp.e;
	}
	
	
	@Override
	public E findMaxWithoutRecursion(){
		if(root == null)
			return null;
		BSTNode<E> tmp = root;
		while(tmp.right!=null){
			tmp = tmp.right;
		}
		return tmp.e;
	}
	
	@Override
	public void levelOrderTraversalWithArray() {
		int i=0,j=0;
		BSTNode<E>[] array = new BSTNode[100];
		array[0] = root;
		while(true){
			BSTNode<E> node = array[i++];
			if(node==null)break;
			if(node.left!=null)array[++j] = node.left;
			if(node.right!=null)array[++j] = node.right;
		}
		for (int s = 0; s<i-1; s++) {
			System.out.println(array[s].e);
		}
		
	}
	
//		1stApproach
//		Not so efficient because Time Complexity of this algorithm is O(n2).
//	is why not Suggestible... There other approach please check relative methods  in this class..
	@Override
	public boolean isBinarySearchTree(BSTNode<E> tree){
		if(tree == null)return true;
		if(isSubTreeLessor(tree.left, tree.e) &&
				isSubTreeGreater(tree.right, tree.e) &&
				isBinarySearchTree(tree.left) &&
				isBinarySearchTree(tree.right)){
			return true;
		}else
			return false;
	}
	
	
	private boolean isSubTreeGreater(BSTNode<E> right, E e) {
		if(right == null)return true;
		if(e(right.e)>e(e) &&
				isSubTreeGreater(right.left, e) &&
				isSubTreeGreater(right.right, e)){
			return true;
		}
		else
			return false;
	}

	private boolean isSubTreeLessor(BSTNode<E> root, E e) {
		if(root == null)return true;
		if(e(root.e)<=e(e) &&
				isSubTreeLessor(root.left, e) &&
				isSubTreeLessor(root.right, e)){
			return true;
		}
		else
			return false;
	}

	private int e(E e) {
		return Integer.parseInt(""+e);
	}

	static class BSTNode<E>{
		E e;
		BSTNode<E> left;
		BSTNode<E> right;
		BSTNode(E e){
			this.e = e;
		}
		@Override
		public String toString() {
			return "BSTNode [e=" + e + "]";
		}
		
	}
	
	
	
	@Override
	public Node<E> insert(Node<E> tree, E e) {
		if (tree == null) {
			tree = new Node<E>(e);
		} else if (e(e ) <= e(tree.e )) {
			tree.left = insert(tree.left, e);
		} else if (e(e ) > e(tree.e )) {
			tree.right = insert(tree.right, e);
		}
		return tree;
	}

	public static class Node<E> {
		E e;
		Node<E> left;
		Node<E> right;

		public Node() {
		}

		public Node(E e) {
			this.e = e;
		}
		@Override
		public String toString() {
			return this.e+"";
		}
	}
	
	@Override
	public boolean search(Node<E> tree, E e) {
		if(e(e ) == e(tree.e )){
			return true;
		}else
		if(e(e ) < e(tree.e )){
			if(tree.left!=null){
				return search(tree.left, e);
			}
		}else
		if(e(e ) > e(tree.e )){
			if(tree.right!=null){
				return search(tree.right, e);
			}
		}
		return false;
	}

	@Override
	public E findMin(Node<E> tree) {
		if(tree==null)
			return null;
		if(tree.left==null)
			return tree.e;
		return findMin(tree.left);
	}

	@Override
	public E findMax(Node<E> tree) {
		if(tree==null)
			return null;
		if(tree.right==null)
			return tree.e;
		return findMin(tree.right);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E findHeight(Node<E> tree) {
		if(tree == null)
			return (E)(Object)(-1);
		E leftHeight = findHeight(tree.left);
		E rightHeight = findHeight(tree.right);
		if(e(leftHeight ) > e(rightHeight ))
	        return (E)(Object)(e(leftHeight ) + 1);
	    else
	        return (E)(Object)(e(rightHeight) +1);
	}

	@Override
	public void levelOrderTraversal(Node<E> tree) {
		if(tree == null)return;
		Queue<Node<E>> queue = new LinkedListQueueImpl<Node<E>>();
		Node<E> current = tree;
		queue.enQueue(current);
		while(!queue.isEmplty()){
			current = queue.deQueue();
			System.out.print(current.e+" ");
			if(current.left!=null)
				queue.enQueue(current.left);
			if(current.right!=null)
				queue.enQueue(current.right);
		}		
	}

	@Override
	public void preOrderDeapthFirstTraversal(Node<E> tree) {
		if(tree==null)return;
		System.out.print(tree.e+" ");
		preOrderDeapthFirstTraversal(tree.left);
		preOrderDeapthFirstTraversal(tree.right);
	}

	@Override
	public void inOrderDeapthFirstTraversal(Node<E> tree) {
		if(tree == null)return;
		inOrderDeapthFirstTraversal(tree.left);
		System.out.print(tree.e+" ");
		inOrderDeapthFirstTraversal(tree.right);
	}

	@Override
	public void postOrderDeapthFirstTraversal(Node<E> tree) {
		if(tree==null)return;
		postOrderDeapthFirstTraversal(tree.left);
		postOrderDeapthFirstTraversal(tree.right);
		System.out.print(tree.e+" ");
	}

	@Override
	public boolean isBinarySearchTree(Node<E> tree) {
		return isBstUtil(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBstUtil(Node<E> tree, int minValue, int maxValue) {
		if (tree == null)
			return true;
		int data = Integer.parseInt(tree.e + "");
		if (data > minValue && data < maxValue
				&& isBstUtil(tree.left, minValue, data)
				&& isBstUtil(tree.right, data, maxValue))
			return true;
		return false;
	}
	
	public boolean isBst(Node<E> tree) {
			boolean lflag = true;
			boolean rflag = true;
			if (tree.left != null){
				if(Integer.parseInt(tree.left.e + "") < Integer.parseInt(tree.e + ""))
					lflag = isBst(tree.left);
				else
					return false;
			}
			if (tree.right != null){
				if(lflag && Integer.parseInt(tree.right.e + "") > Integer.parseInt(tree.e + ""))
					rflag = isBst(tree.right);
				else
					return false;
			}
		return lflag && rflag;
	}

	@Override
	public Node<E> deleteElement(Node<E> tree, E e) {
		/*
		 * Case1 : Check node whether it has no children, If so delete directly.
		 * Case2 : Check node whether it has only 1 child, If so link parent and child of this node and delete it.
		 * Case3 : Find out minimum value node from its right sub tree,(also called suc ) and delete that node and replace it with current node. 
		 */
		if(tree == null) return tree;
		int ip = Integer.parseInt(e+"");
		int rValue = Integer.parseInt(tree.e+"");
		if(ip < rValue)
			tree.left = deleteElement(tree.left, e);
		else if(ip > rValue)
			tree.right = deleteElement(tree.right, e);
		else{
			//We got the node to delete
			if(tree.left == null && tree.right == null)
				tree = null;
			else if(tree.left == null){
				tree = tree.right;
			}
			else if(tree.right == null){
				tree = tree.left;
			}
			else{
				Node<E> rMin = findMinimum(tree.right);
				tree.e = rMin.e;
				tree.right = deleteElement(tree.right, rMin.e);
			}
		}
		return tree;
	}
	
	public Node<E> findMinimum(Node<E> tree) {
		Node<E> current = tree;
		if(tree==null)
			return null;
		while(current.left!=null){
			current = current.left;
		}
		return current;
	}

	@Override
	public BSTNode<E> getInOrderSuccessor(BSTNode<E> tree, E e) {
		/*
		 * 
		 * Case 1 : Node has right sub tree.
		 * 
		 * 			Go deep to the left most node in right sub tree.
		 * 			OR
		 * 			Find minimum in right sub tree.
		 * 
		 * Case2 : Node does not have right sub tree.
		 * 
		 * 			Go to the nearest ancestor for which given node would be in left sub tree.
		 * 
		 * 
		 * Case1:If node has right sub tree then successor is min element in the
		 * right sub tree 
		 * Case2:If give node has no right subtree then the successor
		 * of the node is nearest ancestor for which given node would be
		 * in left sub tree
		 */
		BSTNode<E> current = findNode(tree, e);
		if(current == null)return null;
		
//		Case1:
		if(current.right!=null){
			BSTNode<E> tmp = current.right;
			while(tmp.left!=null){
				tmp = tmp.left;
			}
			return tmp;
		}
		else{
//		Case2:
			BSTNode<E> ancestor = tree;
			BSTNode<E> successor = null;
		while(ancestor!=current){
			int ansData = Integer.parseInt(ancestor.e+"");
			int currData = Integer.parseInt(current.e+"");
			if(currData<ansData){
				successor = ancestor;
				ancestor = ancestor.left;
			}else
				ancestor = ancestor.right;
		}
		return successor;
		}
	}

	private BSTNode<E> findNode(BSTNode<E> tree, E e) {
		if(e(e ) == e(tree.e )){
			return tree;
		}else
		if(e(e ) < e(tree.e )){
			if(tree.left!=null){
				return findNode(tree.left, e);
			}
		}else
		if(e(e ) > e(tree.e )){
			if(tree.right!=null){
				return findNode(tree.right, e);
			}
		}
		return null;
	}

	@Override
	public E findHeight(BSTNode root) {
		if(root == null)
			return (E)(Object)(-1);
		E leftHeight = findHeight(root.left);
		E rightHeight = findHeight(root.right);
		if(e(leftHeight ) > e(rightHeight ))
	        return (E)(Object)(e(leftHeight ) + 1);
	    else
	        return (E)(Object)(e(rightHeight) +1);
	}

	E findDeapth(Node<E> tree, E deapth) {
		if (tree == null)
			return deapth;
		E leftDeapth = findDeapth(tree.left, (E) (Object) (e(deapth) + 1));
		E rightDeapth = findDeapth(tree.right, (E) (Object) (e(deapth) + 1));
		return e(leftDeapth) > e(rightDeapth) ? leftDeapth : rightDeapth;
	}
	
	@Override
	public E findDeapth(Node<E> tree) {
		return findDeapth(tree, (E)(Object)(-1));
	}
}