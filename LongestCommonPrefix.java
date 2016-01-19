package com.nnk.container;
/*
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * */
class Solution {
    public String longestCommonPrefix(String[] strs) {
    	String comStr = "";
    	if (strs.length == 0) {
			return "";
		}
    	if (strs.length == 1) {
			return strs[0];
		}
        char ch;
        for (int i = 0; i < strs[0].length(); i++) {
        	ch = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length() || ch != strs[j].charAt(i)) {
					return comStr;
				}
			}
			comStr += ch;
		}
        return comStr;
    }
}

public class Main {
   public static void main(String[] args) {
	   Solution s = new Solution();
	   String []str = {"hello", "hell", "hillex"};
	   System.out.println(s.longestCommonPrefix(str));
   }
}
