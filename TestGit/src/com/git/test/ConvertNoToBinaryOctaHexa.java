package com.jatin.ds.binary;

public class ConvertNoToBinaryOctaHexa {

	public static void main(String[] args) {
		/*for (int i = 0; i < 100; i = i + 8) {
			System.out.println("Binary Format of " + i + ": "
					+ Integer.toBinaryString(i));
		}

		convertToBinary(88);
		System.out.println();*/
//		convertToBinary(10);
//		convertToOctal(100);
//		convertToHexa(94);
//		System.out.println();
//		System.out.println(05555555555);
//		System.out.println();
//		System.out.println(0x5e);
		System.out.println(toUnsignedString(10));
	}

	public static void convertToHexa(int input){
		char[] cArray = new char[32];
		for(int i = 31; i>=0; i--){
			cArray[i] = digits[input%16];
			input = input/16;
		}
		for(int i = 0; i< cArray.length; i++){
			System.out.print(cArray[i]);
		}
	}
	
	public static void convertToOctal(int input){
		int[] bArray = new int[32];
		for(int i = 31; i >= 0; i--){
			bArray[i] = input % 8;
			input = input / 8;
		}
		for (int i = 0; i < bArray.length; i++) {
			System.out.print(bArray[i]);
		}
	}
	
	public static void convertToBinary(int input) {
		int[] bArray = new int[32];
		for(int i = 31; i >= 0; i--){
			bArray[i] = input % 2;
			input = input / 2;
		}
		for (int i = 0; i < bArray.length; i++) {
			System.out.print(bArray[i]);
		}
	}
	
	final static char[] digits = {
		'0' , '1' , '2' , '3' , '4' , '5' ,
		'6' , '7' , '8' , '9' , 'a' , 'b' ,
		'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
		'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
		'o' , 'p' , 'q' , 'r' , 's' , 't' ,
		'u' , 'v' , 'w' , 'x' , 'y' , 'z'
	    };
	
	private static String toUnsignedString(int i) {
		char[] buf = new char[32];
		int charPos = 32;
		int radix = 1 << 1;
		int mask = radix - 1;
		System.out.println("radix..."+radix);
		System.out.println("mask..."+mask);
		do {
			System.out.println("i..."+i);
			System.out.println("i & mask..."+(i & mask));
			System.out.println("digits[i & mask]."+digits[i & mask]);
			buf[--charPos] = digits[i & mask];
			i >>>= 1;
		} while (i != 0);

		return new String(buf, charPos, (32 - charPos));
	}
}
