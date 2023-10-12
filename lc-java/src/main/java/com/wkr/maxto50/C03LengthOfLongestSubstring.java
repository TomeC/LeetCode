package com.wkr.maxto50;

import com.wkr.common.Utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description: https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @date 2023/9/22 17:48
 */
public class C03LengthOfLongestSubstring {
    public static void main(String[] args) {
        Utils.check(lengthOfLongestSubstring("tmmzuxt"), 5);
        Utils.check(lengthOfLongestSubstring("aabcd"), 4);
        Utils.check(lengthOfLongestSubstring("bpfbhmipx"), 7);
        Utils.check(lengthOfLongestSubstring("abcabcbb"), 3);
        Utils.check(lengthOfLongestSubstring("abcadbcbb"), 4);
        Utils.check(lengthOfLongestSubstring("bbbbb"), 1);
        Utils.check(lengthOfLongestSubstring("pwwkew"), 3);

    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 1) {
            return s.length();
        }
        int begin = 0, max = 0;
        Set<Character> cset = new HashSet<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (cset.contains(s.charAt(i))) {
                if (max < i-begin) {
                    max = i-begin;
                }
                while (s.charAt(begin) != s.charAt(i)) {
                    cset.remove(s.charAt(begin));
                    begin++;
                }
                begin++;
            } else {
                cset.add(s.charAt(i));
            }
        }
        if (max < s.length()-begin) {
            max = s.length()-begin;
        }
        return max;
    }
    public static int lengthOfLongestSubstringOrignal(String s) {
        if (s == null || s.length() <= 1) {
            return s.length();
        }
        int max = 0;
        Map<Character, Short> cMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                Character c = s.charAt(j);
                Short mi = cMap.get(c);
                if (mi == null) {
                    cMap.put(c, (short) j);
                } else {
                    if (max < cMap.size()) {
                        max = cMap.size();
                    }
                    if (max > cMap.size()+s.length()-j) {
//                        System.out.printf("%d > %d direct return \n", max, s.length()-i);
                        return max;
                    }
//                    System.out.printf("%d skip to %d \n", i, j);
                    cMap.keySet().removeIf(item -> cMap.get(item.charValue()) < mi);
                    i = j;
                    cMap.put(c, (short) j);
                }
            }
            if (max < cMap.size()) {
                max = cMap.size();
            }
        }
        return max;
    }
}
