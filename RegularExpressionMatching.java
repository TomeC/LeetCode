package com.nnk.container;
/*
 * 10. Regular Expression Matching
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).

 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)

 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * */
class Solution {
    public boolean isMatch(String s, String p) {
    	if (p.length() == 0) {
    		return s.length() == 0;
		}
    	if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() == 0 || (p.charAt(0) == '.' && s.charAt(0) == p.charAt(0))) {
				return false;
			}
			return isMatch(s.substring(1, s.length()), p.substring(1, p.length()));
		}
    	int i = -1;
    	while (i < s.length() && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
    		if (isMatch(s.substring(i+1, s.length()), p.substring(2, p.length()))) {
				return true;
			}
    		++i;
		}
    	return false;
    }
}

public class Main {
   public static void main(String[] args) {
	   Solution s = new Solution();
	   System.out.println(s.isMatch("aa", "c*aa"));
   }
}
