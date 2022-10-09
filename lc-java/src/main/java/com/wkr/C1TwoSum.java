package com.wkr;

/**
 * @author 王锟
 * @Description:
 * @date 2022/3/1322:27
 */
public class C1TwoSum {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}
