package com.nnk.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 18. 4Sum
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 	Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * 	The solution set must not contain duplicate quadruplets.
 * 	For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * 	A solution set is:
 * 	(-1,  0, 0, 1)
 * 	(-2, -1, 1, 2)
 * 	(-2,  0, 0, 2)
 * */
class Solution {
	 public List<List<Integer>> fourSum(int[] nums, int target) {
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 if (nums.length < 4) {
			 return result;
		 }
		 Arrays.sort(nums);
		 int low, high, value;
		 for (int i = 0; i < nums.length-3; i++) {
			for (int j = i+1; j < nums.length-2; j++) {
				low = j+1;
				high = nums.length-1;
				while (low < high) {
					value = nums[i]+nums[j]+nums[low]+nums[high];
					if (value == target) {
						List<Integer> li = new ArrayList<>();
						li.add(nums[i]);
						li.add(nums[j]);
						li.add(nums[low]);
						li.add(nums[high]);
						result.add(li);
						while (low < high && nums[low] == nums[low+1]) 
							low++;
						low++;
						while (low < high && nums[high] == nums[high-1]) 
							high--;
						high--;
					} else if (value < target) {
						while (low < high && nums[low] == nums[low+1]) 
							low++;
						low++;
					} else {
						while (low < high && nums[high] == nums[high-1]) 
							high--;
						high--;
					}
				}
				while (j+1 < nums.length-2 && nums[j] == nums[j+1]) 
					j++;
			}
			while (i+1 < nums.length-3 && nums[i] == nums[i+1]) 
				i++;
		}
		return result;
	 }
}

public class Main {
   public static void main(String[] args) {
	   int[] nums = {-1, -1 ,0,1, 1,2};
	   Solution s = new Solution();
	   System.out.println(s.fourSum(nums, 0));
   }
}
