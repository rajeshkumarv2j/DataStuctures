package com.jrk.ds.stack.test;

import com.jrk.ds.stack.ArrayStackImpl;
import com.jrk.ds.stack.Stack;

public class ArrayStackTest {
	public static void main(String[] args) {
		Stack<Integer> stack = new ArrayStackImpl<Integer>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack);
		
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack);
		
		System.out.println(stack.top());
		System.out.println(stack);
		
		System.out.println(stack.isEmpty());
		System.out.println(stack);
		
		stack.reverse();
		System.out.println(stack);
	}
}
