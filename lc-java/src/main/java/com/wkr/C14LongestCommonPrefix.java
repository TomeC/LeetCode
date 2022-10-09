package com.wkr;
/*
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * */
public class C14LongestCommonPrefix {
	public static void main(String[] args) {
		C14LongestCommonPrefix s = new C14LongestCommonPrefix();
		String []str = {"hello", "hell", "hillex"};
		System.out.println(s.longestCommonPrefix(str));
	}

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

