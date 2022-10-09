package com.wkr;
/*
 * 12. Integer to Roman
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * */
public class C12IntegertoRoman {
	public static void main(String[] args) {
		C12IntegertoRoman s = new C12IntegertoRoman();
		System.out.println("3: "+s.intToRoman(3));
		System.out.println("11: "+s.intToRoman(11));
		System.out.println("79: "+s.intToRoman(79));
		System.out.println("99: "+s.intToRoman(99));
		System.out.println("1999: "+s.intToRoman(1999));
	}

	String intToRoman(int num) {
		String strNum = "";
		while (num > 0) {
			if (num >= 1000) {
				strNum += "M";
				num -= 1000;
			} else if (num >= 900){
				strNum += "CM";
				num -= 900;
			} else if (num >= 500) {
				strNum += "D";
				num -= 500;
			} else if (num >= 400){
				strNum += "CD";
				num -= 400;
			} else if (num >= 100) {
				strNum += "C";
				num -= 100;
			} else if (num >= 90){
				strNum += "XC";
				num -= 90;
			} else if (num >= 50) {
				strNum += "L";
				num -= 50;
			} else if (num >= 40){
				strNum += "XL";
				num -= 40;
			} else if (num >= 10) {
				strNum += "X";
				num -= 10;
			} else if (num >= 9){
				strNum += "IX";
				num -= 9;
			} else if (num >= 5) {
				strNum += "V";
				num -= 5;
			} else if (num >= 4){
				strNum += "IV";
				num -= 4;
			} else if (num >= 1) {
				strNum += "I";
				num -= 1;
			}
		}
		return strNum;
    }
}

