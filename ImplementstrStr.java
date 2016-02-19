package com.nnk.container;

/*
 * 28. Implement strStr()
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * */
class Solution {
    public int strStr(String haystack, String needle) {
    	for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
    		int j = 0;
			for (; j < needle.length(); j++) {
				if (needle.charAt(j) != haystack.charAt(i+j)) {
					break;
				}
			}
			if (j == needle.length()) {
				return i;
			}
		}
        return -1;
    }
}
public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.strStr("", ""));
	}
}
