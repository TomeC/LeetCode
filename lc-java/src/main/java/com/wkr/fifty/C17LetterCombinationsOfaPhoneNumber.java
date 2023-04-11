package com.wkr.fifty;

import java.util.ArrayList;
import java.util.List;

/*
 * 17. Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 0() 1() 2(abc) 3(def) 4(ghi) 5(jkl) 6(mno) 7(pqrs) 8(tuv) 9(wxyz)
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * */
public class C17LetterCombinationsOfaPhoneNumber {
	public static void main(String[] args) {
		C17LetterCombinationsOfaPhoneNumber s = new C17LetterCombinationsOfaPhoneNumber();
		System.out.println(s.letterCombinations("33"));
	}

	public List<String> letterCombinations(String digits) {
		if (digits.indexOf('0') != -1 || digits.indexOf('1') != -1) {
			return null;
		}
		List<String> ls = new ArrayList<>();
		String[] num = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		for (int i = 0; i < digits.length(); i++) {
			int pos = digits.charAt(i)-'0';
			if (pos < 0 || pos > 9) {
				return null;
			}
			if (ls.isEmpty() == true) {
				for (int j = 0; j < num[pos].length(); j++) {
					String s = Character.toString(num[pos].charAt(j));
					ls.add(s);
				}
				continue;
			}
			List<String> tmp = new ArrayList<>();
			for (int j = 0; j < ls.size(); j++) {
				for (int k = 0; k < num[pos].length(); k++) {
					tmp.add(ls.get(j)+Character.toString(num[pos].charAt(k)));
				}
			}
			ls = tmp;
		}
		return ls;
    }
}
