package com.jatin.ps.spoj;

import java.util.ArrayList;
import java.util.List;

public class IdentifyTheDuplicates {
	public static void main(String[] args) {
		int[] a = {1,1,4,5,6,6,7,7,7,8,9,0};
		
		List<Integer> ndl = new ArrayList<Integer>();
		List<Integer> dl = new ArrayList<Integer>();
		
//		With Java
		for(int i=0; i<a.length; i++){
			if(ndl.contains(a[i])){
				if(!dl.contains(a[i])){
					dl.add(a[i]);
					ndl.remove(ndl.indexOf(a[i]));
				}
			}else{
				ndl.add(a[i]);
			}
		}
		displyArray(ndl.toArray());
		displyArray(dl.toArray());
		
		
		ndl.clear();
		dl.clear();
//		With Java Only duplicates
		
		for(int i=0; i<a.length; i++){
			if(ndl.contains(a[i])){
				if(!dl.contains(a[i])){
					dl.add(a[i]);
				}
			}else{
				ndl.add(a[i]);
			}
		}
		displyArray(dl.toArray());
		
		
	}
	
	static void displyArray(Object[] objects){
		for (Object object : objects) {
			System.out.print(object);
		}
		System.out.println();
	}
}