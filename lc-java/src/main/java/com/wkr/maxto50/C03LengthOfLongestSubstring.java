package com.wkr.maxto50;

import com.wkr.common.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @date 2023/9/22 17:48
 */
public class C03LengthOfLongestSubstring {
    public static void main(String[] args) {
        Utils.check(lengthOfLongestSubstring("abcabcbb"), 3);
        Utils.check(lengthOfLongestSubstring("abcadbcbb"), 3);
        Utils.check(lengthOfLongestSubstring("bbbbb"), 1);
        Utils.check(lengthOfLongestSubstring("pwwkew"), 3);
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 1) {
            return s.length();
        }
        for (int i = 0; i < s.length(); i++) {
            Set<Short> cset = new HashSet<>();

        }
        return 0;
    }
}
