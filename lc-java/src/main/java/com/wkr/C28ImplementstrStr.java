package com.wkr;

/*
 * 28. Implement strStr()
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * */
public class C28ImplementstrStr {
	public static void main(String[] args) {
		C28ImplementstrStr s = new C28ImplementstrStr();
		System.out.println(s.strStr("", ""));
	}

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
