package com.wkr.maxto50;

import com.wkr.common.Utils;

/**
 * @author wkr
 * @Description: https://leetcode.cn/problems/string-to-integer-atoi/
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 * @date 2023/10/12 17:13
 */
public class C08MyAtoi {
    public static void main(String[] args) {
        Utils.check(myAtoi("   +0000000000012345678"), 12345678);
        Utils.check(myAtoi("42"), 42);
        Utils.check(myAtoi("  -42"), -42);
        Utils.check(myAtoi("4193 with words"), 4193);
        Utils.check(myAtoi("words and 987"), 0);
        Utils.check(myAtoi(" +7"), 7);
        Utils.check(myAtoi("21474836460"), 2147483647);
    }
    public static int myAtoi(String s) {
        boolean nflag = false;
        int start = 0;
        while (start < s.length()) {
            if (s.charAt(start) == '-' || s.charAt(start) == '+') {
                nflag = (s.charAt(start) == '-');
                start++;
                break;
            }
            if (s.charAt(start) >='0' && s.charAt(start) <= '9') {
                break;
            }
            if (s.charAt(start) != ' ') {
                return 0;
            }
            start++;
        }
        long res = 0;
        for (int i = 0; i < s.length()-start; i++) {
            if (s.charAt(i+start) < '0' || s.charAt(i+start) > '9') {
                break;
            }
            res = res*10 + (s.charAt(i+start)-'0');
            if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
                break;
            }
        }
        if (nflag) {
            res = -res;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)res;
    }
}
