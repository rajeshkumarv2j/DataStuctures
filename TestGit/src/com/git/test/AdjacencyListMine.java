package com.jrk.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyListMine {

	private static final int MAX_VERTEXS = 10;
	private final LinkedList<Integer>[] linkedListArray;
	private static int sizeOfVertices;

	@SuppressWarnings("unchecked")
	public AdjacencyListMine() {
		linkedListArray = new LinkedList[MAX_VERTEXS];
		for(int i=0; i<linkedListArray.length; i++){
			linkedListArray[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int s, int d) {
		LinkedList<Integer> foundList = null;
		for(int i=0; i< sizeOfVertices; i++){
			if(linkedListArray[i].get(0) == s){
				foundList = linkedListArray[i];
				break;
			}
		}
		if(foundList==null){
			linkedListArray[sizeOfVertices].add(s);
			linkedListArray[sizeOfVertices].add(d);
			sizeOfVertices++;
		}else{
			foundList.add(1, d);
		}
		
	}

	public void removeEdge(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public List<Integer> outEdges(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> inEdges(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i< sizeOfVertices; i++){
			Iterator<Integer> iterator = linkedListArray[i].iterator();
			builder.append(iterator.next()+": ");
			while(iterator.hasNext())
				builder.append(iterator.next()+" ");
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public static void main(String[] args) {
		AdjacencyListMine adjacencyListMine = new AdjacencyListMine();
		adjacencyListMine.addEdge(0, 1);
		adjacencyListMine.addEdge(0, 2);
		adjacencyListMine.addEdge(0, 3);
		
		adjacencyListMine.addEdge(1, 2);
		adjacencyListMine.addEdge(1, 3);
		adjacencyListMine.addEdge(1, 4);
		
		adjacencyListMine.addEdge(2, 1);
		adjacencyListMine.addEdge(2, 2);
		adjacencyListMine.addEdge(2, 3);
		
		adjacencyListMine.addEdge(3, 1);
		adjacencyListMine.addEdge(3, 2);
		adjacencyListMine.addEdge(3, 4);
		
		System.out.println(adjacencyListMine);
	}
}
