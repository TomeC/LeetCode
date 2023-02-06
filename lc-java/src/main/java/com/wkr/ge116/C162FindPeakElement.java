package com.wkr.ge116;

import com.wkr.Utils;

/**
 * @Description:
 * @date: 2023/2/6 18:55
 * @author: wangkun
 */
public class C162FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if (nums.length < 2 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length-1] > nums[nums.length-2]) {
            return nums.length-1;
        }
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Utils.check(findPeakElement(new int[]{1,2}), 1);
        Utils.check(findPeakElement(new int[]{2,1}), 0);
        Utils.check(findPeakElement(new int[]{1,2,3,1}), 2);
        Utils.check(findPeakElement(new int[]{1,2,1,3,5,6,4}), 1);
    }
}
