package com.wkr.ge116;

import com.wkr.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @date: 2022/12/15 19:28
 * @author: wangkun
 */
public class C128LongestConsecutive {
    public static void main(String[] args) {
        Utils.check(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}), 9);
        Utils.check(longestConsecutive(new int[]{1}), 1);
        Utils.check(longestConsecutive(new int[]{}), 0);
        Utils.check(longestConsecutive(new int[]{100,4,200,1,3,2}), 4);
    }
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> iset = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int ilong = 1;
            int left = nums[i]-1;
            iset.remove(nums[i]);
            while (iset.contains(left)) {
                ilong++;
                iset.remove(left);
                left--;
            }
            int right = nums[i]+1;
            while (iset.contains(right)) {
                ilong++;
                iset.remove(right);
                right++;
            }
            if (ilong > longest) {
                longest = ilong;
            }
        }
        return longest;
    }
}
