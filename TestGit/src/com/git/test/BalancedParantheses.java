package com.jrk.ds.stack.programs;

import java.util.Scanner;

import com.jrk.ds.stack.ArrayStackImpl;
import com.jrk.ds.stack.Stack;

public class BalancedParantheses {
	public static void main(String[] args) {
		char[] chars = new Scanner(System.in).next().toCharArray();
		if (checkvalid(chars))
			System.out.println(new String(chars) + " is valid");
		else
			System.out.println(new String(chars) + " is invalid");
		
		System.out.println(stack);
	}

	public static Stack<Character> stack;
	
	private static boolean checkvalid(char[] cs) {
		stack = new ArrayStackImpl<Character>(10000);
		for(int i=0; i<cs.length;i++){
			if(isOpen(cs[i])){
				stack.push(cs[i]);
			}else if(isClose(cs[i])){
				if(validate(cs[i])){
					stack.pop();
				}else return false;
			}
		}
		return stack.isEmpty();
	}

	private static boolean validate(char c) {
		if(stack.isEmpty() || stack.top() != getOpposite(c)){
			return false;
		}
		return true;
	}

	private static Character getOpposite(char c) {
		switch (c) {
		case '(':
			return ')';
		case ')':
			return '(';
		case '{':
			return '}';
		case '}':
			return '{';
		case '[':
			return ']';
		case ']':
			return '[';
		default:
			return null;
		}
	}

	private static boolean isOpen(char c) {
		return (c == '{' || c == '[' || c == '(') ? true : false;
	}

	private static boolean isClose(char c) {
		return (c == '}' || c == '}' || c == '}') ? true : false;
	}
}
