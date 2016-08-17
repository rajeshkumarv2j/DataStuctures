package com.jatin.ds.trees;

public class BTree {

	private BTreeNode root; // Pointer to root node
	private int t; // Minimum degree

	// Constructor (Initializes tree as empty)
	public BTree(int _t) {
		root = null;
		t = _t;
	}

	// function to traverse the tree
	public void traverse() {
		if (root != null)
			root.traverse();
	}

	// function to search a key in this tree
	public BTreeNode search(int k) {
		return (root == null) ? null : root.search(k);
	}

	// The main function that inserts a new key in this B-Tree
	void insert(int k) {
		// If tree is empty
		if (root == null) {
			// Allocate memory for root
			root = new BTreeNode(t, true);
			root.keys[0] = k; // Insert key
			root.n = 1; // Update number of keys in root
		} else // If tree is not empty
		{
			// If root is full, then tree grows in height
			if (root.n == 2 * t - 1) {
				// Allocate memory for new root
				BTreeNode s = new BTreeNode(t, false);

				// Make old root as child of new root
				s.c[0] = root;

				// Split the old root and move 1 key to the new root
				s.splitChild(0, root);

				// New root has two children now. Decide which of the
				// two children is going to have new key
				int i = 0;
				if (s.keys[0] < k)
					i++;
				s.c[i].insertNonFull(k);

				// Change root
				root = s;
			} else
				// If root is not full, call insertNonFull for root
				root.insertNonFull(k);
		}
	}

	void remove(int k)
	{
	    if (root==null)
	    {
	        System.out.print( "The tree is empty\n");
	    }
	 
	    // Call the remove function for root
	    root.remove(k);
	 
	    // If the root node has 0 keys, make its first child as the new root
	    //  if it has a child, otherwise set root as NULL
	    if (root.n==0)
	    {
	        if (root.leaf)
	            root = null;
	        else
	            root = root.c[0];
	    }
	}
	

	// Driver program to test above functions
	public static void main(String[] args) {
		BTree t = new BTree(3); // A B-Tree with minium degree 3
		t.insert(10);
		t.insert(20);
		t.insert(5);
		t.insert(6);
		t.insert(12);
		t.insert(30);
		t.insert(7);
		t.insert(17);
		t.remove(30);

		System.out.println(" Traversal of the constucted tree is ");
		t.traverse();

		int k = 6;
		System.out.print((t.search(k) != null) ? " \nPresent"
				: " \nNot Present");

		k = 15;
		System.out.print((t.search(k) != null) ? " \nPresent"
				: " \nNot Present");
	}
}