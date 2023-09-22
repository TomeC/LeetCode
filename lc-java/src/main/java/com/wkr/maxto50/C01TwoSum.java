package com.wkr.maxto50;

import com.wkr.common.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wkr
 * @Description: find target in arrays
 * @date 2022/3/1322:27
 */
public class C01TwoSum {
    public static void main(String[] args) {
        Utils.check(twoSum2(new int[]{1,2,3}, 3), new int[]{0,1});
        Utils.check(twoSum2(new int[]{3,3}, 6), new int[]{0,1});
    }
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> resultMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer diff = target-nums[i];
            Integer index = resultMap.get(diff);
            if (index != null) {
                return new int[]{index, i};
            }
            resultMap.put(nums[i], i);
        }
        return new int[2];
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
