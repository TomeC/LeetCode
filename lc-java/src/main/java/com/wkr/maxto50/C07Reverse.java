package com.wkr.maxto50;

import com.wkr.common.Utils;

/**
 * @author wkr
 * @Description: https://leetcode.cn/problems/reverse-integer/
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * -231 <= x <= 231 - 1
 * @date 2023/10/12 16:42
 */
public class C07Reverse {
    public static void main(String[] args) {
        Utils.check(reverse(123), 321);
        Utils.check(reverse(-123), -321);
        Utils.check(reverse(120), 21);
        Utils.check(reverse(0), 0);
    }
    public static int reverse(int x) {
        long res = 0, tmp = x;
        boolean nflag = (x < 0);
        if (nflag) {
            tmp = -x;
        }
        while (tmp != 0) {
            res = (res*10)+(tmp%10);
            tmp = tmp/10;
        }
        if (nflag) {
            res = -res;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)res;
    }
}
