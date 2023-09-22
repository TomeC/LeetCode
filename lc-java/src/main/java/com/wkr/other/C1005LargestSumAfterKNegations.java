package com.wkr.other;

import com.wkr.common.Utils;

import java.util.Arrays;

/**
 * @author wkr
 * @Description:
 * @date 2021/12/421:39
 */
public class C1005LargestSumAfterKNegations {
    public static void main(String[] args) {
        C1005LargestSumAfterKNegations kNegations = new C1005LargestSumAfterKNegations();
        Utils.check(kNegations.largestSumAfterKNegations(new int[]{4,2,3}, 1)==5, "1 fail");
        Utils.check(kNegations.largestSumAfterKNegations(new int[]{3,-1,0,2}, 3)==6, "2 fail");
        Utils.check(kNegations.largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2)==13, "3 fail");
    }
    public int largestSumAfterKNegations(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0, min = 101;
        for (int n : nums) {
            if (n < 0) {
                if (k > 0) {
                    n = -n;
                    k--;
                }
            }
            sum += n;
            if (min > n) {
                min = n;
            }
        }
        if (k > 0 && k % 2 == 1) {
             sum -= min*2;
        }
        return sum;
    }
}
