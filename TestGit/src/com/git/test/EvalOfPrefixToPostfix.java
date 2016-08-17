package com.jrk.ds.stack.programs;

import java.util.Scanner;

import com.jrk.ds.stack.SinglyLinkedListStackImpl;
import com.jrk.ds.stack.Stack;

/***
 * Actual Notes:
 * 
 * 	Infix Expression	Prefix Expression	Postfix Expression 
 * 	 A + B					+ A B				A B +
 * 	 A + B * C				+ A * B C			A B C * +
 * 	(A + B) * C				* + A B C			A B + C *
 * 
 * 	A + B * C + D			+ + A * B C D		A B C * + D +
 * 	(A + B) * (C + D)		* + A B + C D		A B + C D + *
 * 	A * B + C * D			+ * A B * C D		A B * C D * +
 * 	A + B + C + D			+ + + A B C D		A B + C + D +
 * 
 * @param args
 */

public class EvalOfPrefixToPostfix {
	public static void main(String[] args) {
		char []ip = new Scanner(System.in).next().toCharArray();
		StringBuffer s = new StringBuffer();
		for (char c : ip) {
			if(isOperand(c+"")){
				s = s.append(c+"");
			}else{
				s.append(","+c+",");
			}
		}
		String[] ifx = s.toString().split(",");
		String[] pfx = infixToPostfix(ifx);
		for (int i = 0; i < pfx.length; i++) {
			System.out.print(pfx[i]);
		}
		System.out.println();
		int result = evaluatePostfixExpression(pfx);
		System.out.println(result);
	}

	private static int evaluatePostfixExpression(String[] pfx) {
		Stack<String> stack = new SinglyLinkedListStackImpl<String>();
		for (int i = 0; i < pfx.length; i++) {
			if(isOperand(pfx[i])){
				stack.push(pfx[i]);
			}else{
				String c2 = stack.pop();
				stack.push(calculate(stack.pop(), c2, pfx[i]));
			}
		}
		return (stack.isEmpty())?0:Integer.parseInt(stack.pop());
	}

	private static String calculate(String c1, String c2, String operator) {
		switch(operator.charAt(0)){
			case '+':
				return ""+(Integer.parseInt(c1)+Integer.parseInt(c2));
			case '-':
				return ""+(Integer.parseInt(c1)-Integer.parseInt(c2));
			case '*':
				return ""+(Integer.parseInt(c1)*Integer.parseInt(c2));
			case '/':
				return ""+(Integer.parseInt(c1)/Integer.parseInt(c2));
			default:
				return "0";
		}
	}
	
	public static String[] infixToPostfix(String[] ifx) {
		String[] pfx = new String[ifx.length];
		int j=0;
		Stack<String> stack = new SinglyLinkedListStackImpl<String>();
		for (int i = 0; i < ifx.length; i++) {
			if(isOperand(ifx[i])){
				pfx[j++] = ifx[i]; 
			}else{//2*3+5-7+10/5*7-1+4*5*6/3
				if(isLowPreferableOperator(ifx[i])){
					while(!stack.isEmpty())
						pfx[j++] = stack.pop();
				}
				stack.push(ifx[i]);
			}
		}
		while(!stack.isEmpty())
			pfx[j++] = stack.pop();
		return pfx;
	}
	
	private static boolean isLowPreferableOperator(String c) {
		if(c.equals("+") || c.equals("-")) 
			return true;
		return false;
	}

	public static boolean isOperand(String c) {
		String []opts = {"*","/","+","-"};
		for (int i = 0; i < opts.length; i++) {
			if(c.equals(opts[i]))
				return false;
		}
		return true;
	}
}
