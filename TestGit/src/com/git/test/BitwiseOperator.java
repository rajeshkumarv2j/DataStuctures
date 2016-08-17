package com.jatin.ds.binary;

public class BitwiseOperator {
	
	void bitOperators(){
		   int a = 60;	/* 60 = 0011 1100 */  
		     int b = 13;	/* 13 = 0000 1101 */
		     int c = 0;

		     c = a & b;       /* 12 = 0000 1100 */ 
		     System.out.println("a & b = " + c );

		     c = a | b;       /* 61 = 0011 1101 */
		     System.out.println("a | b = " + c );

		     c = a ^ b;       /* 49 = 0011 0001 */
		     System.out.println("a ^ b = " + c );

		     c = ~a;          /*-61 = 1100 0011 */
		     System.out.println("~a = " + c );

		     c = a << 2;     /* 240 = 1111 0000 */
		     System.out.println("a << 2 = " + c );

		     c = a >> 2;     /* 15 = 1111 */
		     System.out.println("a >> 2  = " + c );

		     c = a >>> 2;     /* 15 = 0000 1111 */
		     System.out.println("a >>> 2 = " + c );
	}
	
	static void and(){
//		for(int i =0 ; i<=100; i= i+10){
			System.out.println(00101010);
//		}
	}
	static void unaryitwiseComplementaryOperator(){
		
		
		System.out.println(Integer.toBinaryString(2));
//		00000000000000000000000000000010
		System.out.println(Integer.toBinaryString(~2));
//		11111111111111111111111111111101
		System.out.println(Integer.toBinaryString(-3));
//		11111111111111111111111111111101
		System.out.println(~5);
		/*
//		System.out.println(~10);
		System.out.println(Integer.toBinaryString(1));
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(-2));

		//it will have all ones
		System.out.println(Integer.toBinaryString(-1));
		
		//this is equal to +0(No sign to 0)
		System.out.println(Integer.toBinaryString(-0));

		//this is equal to -0(No sign to 0)
		System.out.println(Integer.toBinaryString(+0));
		
		//Smallest –ve number in twos complement is leading with 1 and followed by all 0000000…
		System.out.println(Integer.toBinaryString(-2147483648));
		
		//Largest +vve number in twos complement is leading with 0 and followed by all 1111111..
		System.out.println(Integer.toBinaryString(2147483647));
*/	}
	
	public static void main1(String args[]) {
		String binary[] = {
		"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
		"1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"
		};
		int a = 3; // 0 + 2 + 1 or 0011 in binary
		int b = 6; // 4 + 2 + 0 or 0110 in binary
		int c = a | b;
		int d = a & b;
		int e = a ^ b;
		int f = (~a & b) | (a & ~b);
		int g = ~a & 0x0f;
		System.out.println(" a = " + binary[a]);
		System.out.println(" b = " + binary[b]);
		System.out.println(" a|b = " + binary[c]);
		System.out.println(" a&b = " + binary[d]);
		System.out.println(" a^b = " + binary[e]);
		System.out.println("~a&b|a&~b = " + binary[f]);
		System.out.println(" ~a = " + binary[g]);
	}
	
	public static void main(String[] args) {
		unSignedRightShift();
//		signedRightShift();
//		signedLeftShift();
//		and();
//		System.out.println(0xff);
//		System.out.println(0101);
		/*
		for(int i =1; i<10737418241073l; i=i+1073741824){
			System.out.println(Integer.toBinaryString(i));
			System.out.println(Integer.toBinaryString(i<<1));
			System.out.println("(i..."+i+")(i<<1..."+(i<<1)+")");
		}
		*/
//		int p = 1073741824;
//		2147483648 if it is long
//		-2147483648 if it is int
		
//		System.out.println(22>>1);
/*		010110
		44
		101100...22<<1
		11
		001011...22>>1
*/
		/*
		System.out.println(Integer.toBinaryString(22));
		System.out.println(22>>1);
		System.out.println(Integer.toBinaryString(22>>1)+"...22>>1");
		System.out.println(22>>>1);
		System.out.println(Integer.toBinaryString(22>>>1)+"...22>>>1");
		
		
		
		10110
		11
		1011...22>>1
		11
		1011...22>>>1


		System.out.println(Integer.toBinaryString(-22));
		System.out.println(-22>>1);
		System.out.println(Integer.toBinaryString(-22>>1)+"...-22>>1");
		System.out.println(-22>>>1);
		System.out.println(Integer.toBinaryString(-22>>>1)+"...-22>>>1");
		10110
		11
		1011...22>>1
		11
		1011...22>>>1
		11111111111111111111111111101010
		-11
		11111111111111111111111111110101...-22>>1
		2147483637
		01111111111111111111111111110101...-22>>>1
*/
		//signedLeftShift();//(moves bits left side s no of times) or.. if n << s; then value is multiplication of 2 power of s. 
		//signedRightShift();//(moves bits right side s no of times) or..  truncating integer division, as computed by the integer division operator /, by 2 to the power s.
		
	}

	private static void unSignedRightShift() {
		char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
				'b', 'c', 'd', 'e', 'f' };
		byte b = (byte) 0xf1;
		byte c = (byte) (b >> 4);
		System.out.println(Integer.toBinaryString(b));
		byte d = (byte) (b >>> 4);
		System.out.println(Integer.toBinaryString(b >>> 4));
		byte e = (byte) ((b & 0xff) >> 4);
		System.out.println(Integer.toBinaryString((b & 0xff) >> 4));
		System.out.println(" b = 0x" + hex[(b >> 4) & 0x0f] + hex[b & 0x0f]);
		System.out.println(" b >> 4 = 0x" + hex[(c >> 4) & 0x0f]
				+ hex[c & 0x0f]);
		System.out.println(" b >>> 4 = 0x" + hex[(d >> 4) & 0x0f]
				+ hex[d & 0x0f]);
		System.out.println("(b & 0xff) >> 4 = 0x" + hex[(e >> 4) & 0x0f]
				+ hex[e & 0x0f]);

	}

	private static void signedLeftShift() {

//		1
		byte a = 64, b;
		int i;
		i = a << 2;
		b = (byte) (a << 2);
		System.out.println("Original value of a: " + a);
		System.out.println("i and b: " + i + " " + b);
		
//		2
		int f = 1;
		for(;f>0;){
			System.out.println(f);
			f<<=1;
		}
		f =1;
		System.out.println(".............");
		for(;f>0;f=f*2){
			System.out.println(f);
		}
		
		System.out.println("3 start");
//		3
		int num = 0xFFFFFFE;
		for(i=0; i<4; i++) {
			num = num << 1;
			System.out.println(num);
		}
		
//0 holding all zero.. now << is trying to add 0 so no different in shifting
		System.out.println(0<<100);
//		000000000000000000000000000000
		System.out.println(Integer.toBinaryString(0));
//		000000000000000000000000000000
	}
	
	private static void signedRightShift() {
		int i = 192;//Integer.MAX_VALUE;
		int j = 0;
		/*i=i>>1;
		System.out.println(Integer.toBinaryString(i));
		i=i>>2;
		System.out.println(Integer.toBinaryString(i));
		i=i>>3;
		System.out.println(Integer.toBinaryString(i));
		System.out.println("...........");*/
		int n = 4;
		System.out.println(i + ":" + Integer.toBinaryString(i));
		System.out.println((i >> j) + ":" + Integer.toBinaryString(i >> j)+" for j:"+j);
		for(int g = 0; g <= n ; g++)
		System.out.println((i >> ++j) + ":" + Integer.toBinaryString(i >> j)+" for j:"+j);
		
/*		2147483647:1111111111111111111111111111111
		2147483647:1111111111111111111111111111111 for j:0
		1073741823:111111111111111111111111111111 for j:1
		536870911:11111111111111111111111111111 for j:2
		268435455:1111111111111111111111111111 for j:3
		134217727:111111111111111111111111111 for j:4
		67108863:11111111111111111111111111 for j:5
		33554431:1111111111111111111111111 for j:6
		16777215:111111111111111111111111 for j:7
		8388607:11111111111111111111111 for j:8
		4194303:1111111111111111111111 for j:9
		2097151:111111111111111111111 for j:10
		1048575:11111111111111111111 for j:11
		524287:1111111111111111111 for j:12
		262143:111111111111111111 for j:13
		131071:11111111111111111 for j:14
		65535:1111111111111111 for j:15
		32767:111111111111111 for j:16
		16383:11111111111111 for j:17
		8191:1111111111111 for j:18
		4095:111111111111 for j:19
		2047:11111111111 for j:20
		1023:1111111111 for j:21
		511:111111111 for j:22
		255:11111111 for j:23
		127:1111111 for j:24
		63:111111 for j:25
		31:11111 for j:26
		15:1111 for j:27
		7:111 for j:28
		3:11 for j:29
		1:1 for j:30
		0:0 for j:31
		2147483647:1111111111111111111111111111111 for j:32
*/		
		
		
/*		long i1 = 10000;//Long.MAX_VALUE;
		long j1 = 1;
		int n1 = 5;
		System.out.println(i1 + ":" + Long.toBinaryString(i1));
		System.out.println((i1 >> j1) + ":" + Long.toBinaryString(i1 >> j1)+" for j:"+j1);
		for(int g = 0; g <= n1 ; g++)
			System.out.println((i1 >> ++j1) + ":" + Long.toBinaryString(i1 >> ++j1)+" for j:"+j1);
*/

//		if - value it adds 1
//		If + value it adds 0
		System.out.println(8>>1);
		System.out.println(Integer.toBinaryString(8));
//		00000000000000000000000000001000
		System.out.println(Integer.toBinaryString(4));
//		00000000000000000000000000000100
		
//		1
		System.out.println(-8>>1);
		System.out.println(Integer.toBinaryString(-8));
//		11111111111111111111111111111000
		System.out.println(Integer.toBinaryString(-4));
//		11111111111111111111111111111100

//-1 holding all ones.. now >> is trying to add one so different in shifting		
//		2
		System.out.println(-1>>1);
//		-1
		System.out.println(Integer.toBinaryString(-1));
//		11111111111111111111111111111111
		
	}
	
	
}