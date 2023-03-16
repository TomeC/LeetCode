package com.wkr.ge116;

import com.wkr.Utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Description: https://leetcode.cn/problems/majority-element/
 * @date: 2023/3/16 14:26
 * @author: wangkun
 */
public class C169MajorityElement {
    public static void main(String[] args) {
        Utils.check(majorityElement(new int[]{3,2,3}), 3);
        Utils.check(majorityElement(new int[]{2,2,1,1,1,2,2}), 2);
    }

    public static int majorityElement(int[] nums) {
        Set<Integer> usedSet = new HashSet<>();
        Random random = new Random();
        while (true) {
            int index = random.nextInt(nums.length);
            if (usedSet.contains(index)) {
                continue;
            }
            usedSet.add(index);
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == nums[index]) {
                    count++;
                }
            }
            if (count > nums.length/2) {
                return nums[index];
            }
        }
    }
}
