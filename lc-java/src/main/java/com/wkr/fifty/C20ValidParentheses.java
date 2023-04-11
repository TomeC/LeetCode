package com.wkr.fifty;

import java.util.Stack;
/*
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * */
public class C20ValidParentheses {
	public static void main(String[] args) {
		C20ValidParentheses s = new C20ValidParentheses();
		System.out.println(s.isValid("()[]{}"));
	}
	public boolean isValid(String s) {
		Stack<Character> sc = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				sc.push(s.charAt(i));
			} else {
				if (sc.empty() || isMatch(sc.pop(), s.charAt(i)) == false) {
					return false;
				}
			}
		}
		return sc.empty();
	}
	private boolean isMatch(char ch, char target) {
		if (ch == '(' && target == ')') {
			return true;
		} else if (ch == '[' && target == ']') {
			return true;
		} else if (ch == '{' && target == '}') {
			return true;
		}
		return false;
	}
}
