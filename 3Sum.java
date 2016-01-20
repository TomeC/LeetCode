package com.nnk.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 *
 *  A solution set is:
 *  (-1, 0, 1)
 *  (-1, -1, 2)
 * */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> lli = new ArrayList<List<Integer>>();
    	if (nums.length < 3) {
			return lli;
		}
    	Arrays.sort(nums);
    	int low, high;
    	for (int i = 0; i < nums.length-2; i++) {
    		low = i+1;
    		high = nums.length-1;
    		while (low < high) {
	    		int value = nums[i]+nums[low]+nums[high];
				if (value == 0) {
					List<Integer> li = new ArrayList<>(3);
					li.add(nums[i]);
					li.add(nums[low]);
					li.add(nums[high]);
					lli.add(li);
					while (low < high && nums[low] == nums[low+1]) ++low;
					while (high > low && nums[high] == nums[high-1]) --high;
					++low;
					--high;
				} else if (value < 0) {
					while (low < high && nums[low] == nums[low+1]) ++low;
					++low;
				} else if (value > 0) {
					while (high > low && nums[high] == nums[high-1]) --high;
					--high;
				}
    		}
    		while (i < nums.length-2 && nums[i] == nums[i+1]) ++i;
    	}
    	return lli;
    }
}

public class Main {
   public static void main(String[] args) {
	   Solution s = new Solution();
	   int []str = {-1, -1, 0, 1, 2, 3};
	   System.out.println(s.threeSum(str));
   }
}
