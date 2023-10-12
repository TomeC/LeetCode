package com.wkr.maxto50;

import com.wkr.common.Utils;

/**
 * @author wkr
 * @Description: https://leetcode.cn/problems/longest-palindromic-substring/
 *
 * @date 2023/10/8 10:21
 */
public class C05LongestPalindrome {
    public static void main(String[] args) {
        Utils.check(longestPalindrome("ab"), "a");
        Utils.check(longestPalindrome("babad"), "bab");
        Utils.check(longestPalindrome("cbbd"), "bb");
        Utils.check(longestPalindrome("a"), "a");
    }
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int begin = 0, maxLen = 1;
        for (int L = 2; L <= s.length(); L++) {
            for (int i = 0; i < s.length(); i++) {
                int right = i+L-1;
                if (right >= s.length()) {
                    break;
                }
                if (s.charAt(i) != s.charAt(right)) {
                    dp[i][right] = false;
                } else {
                    if (right-i<3) {
                        dp[i][right] = true;
                    } else {
                        dp[i][right] = dp[i+1][right-1];
                    }
                }
                if (dp[i][right] && L > maxLen) {
                    maxLen = L;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }
    public static String longestPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int maxLeft = 0, maxRight = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
            }
            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                right++;
            }
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right-left > maxRight-maxLeft) {
                maxLeft = left;
                maxRight = right;
            }
        }
        return s.substring(maxLeft+1, maxRight);
    }

}
