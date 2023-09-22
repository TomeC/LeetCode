package com.wkr.maxto200;

import com.wkr.common.Utils;

/**
 * https://leetcode.cn/problems/fraction-to-recurring-decimal/
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 如果存在多个答案，只需返回 任意一个 。
 *
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 */
public class C166FractionToDecimal {
    public static void main(String[] args) {
        C166FractionToDecimal fractionToDecimal = new C166FractionToDecimal();
        Utils.check(fractionToDecimal.fractionToDecimal(1, 2), "0.5");
        Utils.check(fractionToDecimal.fractionToDecimal(2, 1), "2");
//        Utils.check(fractionToDecimal.fractionToDecimal(4, 333), "0.(012)");
    }
    public String fractionToDecimal(int numerator, int denominator) {
        int intResult = numerator/denominator;
        numerator %= denominator;
        StringBuilder decimalBuilder = new StringBuilder(16);
        if (numerator == 0) {
            return Integer.toString(intResult);
        }

        decimalBuilder
                .append(intResult)
                .append('.');
        numerator *= 10;
        while (numerator != 0) {
            if (numerator >= denominator) {
                decimalBuilder.append(numerator/denominator);
                numerator %= denominator;
            } else {
                decimalBuilder.append(0);
                numerator *= 10;
            }
        }
        return decimalBuilder.toString();
    }


}
