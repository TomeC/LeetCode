package com.wkr.hundredfifty;

import com.wkr.Utils;

/**
 * @Description:
 * @date: 2023/1/5 17:11
 * @author: wangkun
 */
public class C137SingleNumber {
    public static void main(String[] args) {
        Utils.check(singleNumber(new int[]{1,3,3,3}), 1);
        Utils.check(singleNumber(new int[]{-1,3,3,3}), -1);
        Utils.check(singleNumber(new int[]{-1,-3,-3,-3}), -1);
        Utils.check(singleNumber(new int[]{1,-3,-3,-3}), -1);
    }
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                if ((num>>i &1) != 0) {
                    sum += 1;
                }
            }
            if (sum%3 != 0) {
                result |= (1<<i);
            }
        }
        return result;
    }
}
