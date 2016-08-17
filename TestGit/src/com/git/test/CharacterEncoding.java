package com.jatin;

import java.nio.charset.Charset;

public class CharacterEncoding {
	public static void main(String[] args) {
		System.out.println("RajehNäàâåêëèï┘█▄▐ëαëß");
//		System.out.println("© A╜↓1NN│┤╡╢╖ │2░▒▓cme, Inc.");
		String s = new String("1xfe 2xfec Rajesh x8⌐º92♥♦┐└╛┴┬├ñ§ó↓├Φ→¿ºÆ┘╡:Ñ↓▬«▬ëM▌≥☻╢á♦∞ôz╙)ⁿ'Åƒ¬♪┘Φ╞VVdφ╞".getBytes(),
				Charset.forName("ISO-8859-1"));
		System.out.println(s);
	}
}
