package com.wkr.maxto50;

import com.wkr.common.Utils;

/**
 * @author wkr
 * @Description: https://leetcode.cn/problems/palindrome-number/
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @date 2023/10/12 17:37
 */
public class C09IsPalindrome {
    public static void main(String[] args) {
        Utils.check(isPalindrome(121));
        Utils.check(!isPalindrome(-121));
        Utils.check(!isPalindrome(10));
        Utils.check(!isPalindrome(Integer.MAX_VALUE));
        Utils.check(!isPalindrome(Integer.MIN_VALUE));
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int[] s = new int[10];
        int left = 0, right = 0;
        while (x != 0) {
            s[right++] = x%10;
            x /= 10;
        }
        right--;
        while (left < right) {
            if (s[left++] != s[right--]) {
                return false;
            }
        }
        return true;
    }
}
