package com.jrk.ds.graph;

// Java Program for union-find algorithm to detect cycle in a graph

public class IsCycleByUnionRank {
	// A union by rank and path compression based program to detect cycle in a
	// graph
	// a structure to represent an edge in graph
	class Edge {
		int src, dest;
	}

	class Subset {
		int parent;
		int rank;
	}

	int V, E; // V. no. of vertices & E.no.of edges
	Edge edge[]; // /collection of all edges
	Subset[] subsets;

	// Creates a graph with V vertices and E edges
	IsCycleByUnionRank(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		subsets = new Subset[V];
		for (int i = 0; i < e; ++i) {
			edge[i] = new Edge();
			subsets[i] = new Subset();
		}

	}

	// A utility function to find set of an element i
	// (uses path compression technique)
	int find(Subset subsets[], int i) {
		// find root and make root as parent of i (path compression)
		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);

		return subsets[i].parent;
	}

	// A function that does union of two sets of x and y
	// (uses union by rank)
	void Union(Subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		// Attach smaller rank tree under root of high rank tree
		// (Union by Rank)
		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;

		// If ranks are same, then make one as root and increment
		// its rank by one
		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	// The main function to check whether a given graph contains cycle or not
	int isCycle(IsCycleByUnionRank graph) {
		int V = graph.V;
		int E = graph.E;

		for (int v = 0; v < V; ++v) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}

		// Iterate through all edges of graph, find sets of both
		// vertices of every edge, if sets are same, then there is
		// cycle in graph.
		for (int e = 0; e < E; ++e) {
			int x = find(subsets, graph.edge[e].src);
			int y = find(subsets, graph.edge[e].dest);

			if (x == y)
				return 1;

			Union(subsets, x, y);
		}
		return 0;
	}

	// Driver Method
	public static void main(String[] args) {
		/*
		 * Let us create following graph 0 | \ | \ 1-----2
		 */
		int V = 3, E = 3;
		IsCycleByUnionRank graph = new IsCycleByUnionRank(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;

		// add edge 1-2
		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;

		// add edge 0-2
		graph.edge[2].src = 0;
		graph.edge[2].dest = 2;

		if (graph.isCycle(graph) == 1)
			System.out.println("graph contains cycle");
		else
			System.out.println("graph doesn't contain cycle");
	}
}