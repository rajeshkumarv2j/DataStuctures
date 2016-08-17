package com.jrk.ds.graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponentsGraph {
	public Node rootNode;
	public ArrayList nodes = new ArrayList();
	public int[][] adjMatrix;// Edges will be represented as adjacency Matrix
	int size;
	int[] conncomp = new int[26];
	int connCompCount = 0;
	
	public void setRootNode(Node n) {
		this.rootNode = n;
	}

	public Node getRootNode() {
		return this.rootNode;
	}

	public void addNode(Node n) {
		nodes.add(n);
		conncomp[(int)n.label-65] = -1;
	}

	// This method will be called to make connect two nodes
	public void connectNode(Node start, Node end) {
		if (adjMatrix == null) {
			size = nodes.size();
			adjMatrix = new int[size][size];
		}

		int startIndex = nodes.indexOf(start);
		int endIndex = nodes.indexOf(end);
		adjMatrix[startIndex][endIndex] = 1;
		adjMatrix[endIndex][startIndex] = 1;
	}

	private Node getUnvisitedChildNode(Node n) {

		int index = nodes.indexOf(n);
		int j = 0;
		while (j < size) {
			if (adjMatrix[index][j] == 1
					&& ((Node) nodes.get(j)).visited == false) {
				return (Node) nodes.get(j);
			}
			j++;
		}
		return null;
	}

	public void identifyConectedComponents(Node root){
		for (int i = 0; i < this.conncomp.length; i++) {
			if(this.conncomp[i]==-1){
				int j = i+this.bfs(root);
				if(j<nodes.size())
					root = (Node) nodes.get(j);
				else
					break;
			}
		}
	}
	// BFS traversal of a tree is performed by the bfs() function
	public int bfs(Node root) {
		int i=0;
		this.setRootNode(root);
		// BFS uses Queue data structure
		Queue q = new LinkedList();
		q.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited = true;
		while (!q.isEmpty()) {
			if(i==0)
				connCompCount++;
			Node n = (Node) q.remove();
			i++;
			conncomp[(int)n.label-65]=connCompCount;
			Node child = null;
			while ((child = getUnvisitedChildNode(n)) != null) {
				child.visited = true;
				printNode(child);
				q.add(child);
			}
		}
		// Clear visited property of nodes
		clearNodes();
		return i;
	}

	// Utility methods for clearing visited property of node
	private void clearNodes() {
		int i = 0;
		while (i < size) {
			Node n = (Node) nodes.get(i);
			n.visited = false;
			i++;
		}
	}

	// Utility methods for printing the node's label
	private void printNode(Node n) {
		System.out.print(n.label + " ");
	}

	static class Node {
		public char label;
		public boolean visited = false;

		public Node(char l) {
			this.label = l;
		}

		@Override
		public String toString() {
			return "Node [label=" + label + ", visited=" + visited + "]";
		}
	}

	public static void main(String[] args) {
		Node nA = new Node('A');
		Node nB = new Node('B');
		Node nC = new Node('C');
		Node nD = new Node('D');
		Node nE = new Node('E');
		Node nF = new Node('F');
		Node nG = new Node('G');
		Node nH = new Node('H');
		Node nI = new Node('I');
		Node nJ = new Node('J');
		Node nK = new Node('K');
		Node nL = new Node('L');
		Node nM = new Node('M');
		

		// Create the graph, add nodes, create edges between nodes
		ConnectedComponentsGraph g = new ConnectedComponentsGraph();
		g.addNode(nA);
		g.addNode(nB);
		g.addNode(nC);
		g.addNode(nD);
		g.addNode(nE);
		g.addNode(nF);
		g.addNode(nG);
		g.addNode(nH);
		g.addNode(nI);
		g.addNode(nJ);
		g.addNode(nK);
		g.addNode(nL);
		g.addNode(nM);
		
		g.connectNode(nA, nB);
		g.connectNode(nA, nE);
		g.connectNode(nA, nF);
		g.connectNode(nB, nE);
		g.connectNode(nB, nC);
		g.connectNode(nC, nD);
		g.connectNode(nD, nE);
		g.connectNode(nE, nF);
		g.connectNode(nH, nG);
		g.connectNode(nH, nI);
		g.connectNode(nG, nI);
		g.connectNode(nJ, nK);
		g.connectNode(nJ, nM);
		g.connectNode(nK, nL);
		g.connectNode(nL, nM);
		
		g.identifyConectedComponents(nA);
	}
}
