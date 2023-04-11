package com.wkr.fifty;
/*
 * 13. Roman to Integer
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 * */
public class C13RomantoInteger {
	public static void main(String[] args) {
		C13RomantoInteger s = new C13RomantoInteger();
		System.out.println("IV: "+s.romanToInt("IV"));
		System.out.println("LIV: "+s.romanToInt("LIV"));
		System.out.println("DCXXI: "+s.romanToInt("DCXXI"));
		System.out.println("DLV: "+s.romanToInt("DLV"));
		System.out.println("MMCDXX: "+s.romanToInt("MMCDXX"));
	}

	public int romanToInt(String s) {
		int numeral = 0;
		int first, second;
		for (int i = 0; i < s.length(); ++i) {
			first = charToInt(s.charAt(i));
			if (i+1 < s.length()) {
				second = charToInt(s.charAt(i+1));
				if (first < second) {
					first = second-first;
					++i;
				}
			}
			numeral += first;
		}
        return numeral;
    }
	private int charToInt(char ch) {
		char c = Character.toUpperCase(ch);
		if (c == 'I') {
			return 1;
		} else if (c == 'V') {
			return 5;
		} else if (c == 'X') {
			return 10;
		} else if (c == 'L') {
			return 50;
		} else if (c == 'C') {
			return 100;
		} else if (c == 'D') {
			return 500;
		} else if (c == 'M') {
			return 1000;
		}
		return 0;
	}
}
