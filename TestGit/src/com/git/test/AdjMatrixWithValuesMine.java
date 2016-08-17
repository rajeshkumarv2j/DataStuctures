package com.jrk.ds.graph;

import java.util.Random;
import java.util.Scanner;

public class AdjMatrixWithValuesMine {
	private int v,e,le[];

	public AdjMatrixWithValuesMine(int v, int e, int[] le) {
		this.v = v;
		this.e = e;
		this.le = le;
	}

	private void createGraph() {
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the No of vertexs...");
		int v = scanner.nextInt();
		System.out.println("Enter the No of Edges...");
		int e = scanner.nextInt();
		int [] le = new int[e];
		for(int i = 0; i < le.length; i++){
			le[i] = new Random().nextInt();
		}
		
		AdjMatrixWithValuesMine amg = new AdjMatrixWithValuesMine(v,e,le);
		amg.createGraph();
		System.out.println(amg);
	}
}