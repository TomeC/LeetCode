package com.wkr.maxto50;
import java.util.Arrays;

/*
 * 16. 3Sum Closest
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * */
public class C16SumClosest {
	public static void main(String[] args) {
		C16SumClosest s = new C16SumClosest();
		int []str = {-1, -1, 0, 1, 2, 3};
		System.out.println(s.threeSumClosest(str, 5));
	}
	// 3 <= nums.length <= 1000
    public int threeSumClosest(int[] nums, int target) {
    	int closest = nums[0]+nums[1]+nums[2];
    	int low, high, value;
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length-2; i++) {
    		low = i+1;
    		high = nums.length-1;
			value = nums[i]+nums[low]+nums[low+1];
			if (value > 0 && target > 0) {
				if (Math.abs(value-target) < Math.abs(closest-target)) {
					closest = value;
				}
				continue;
			}
			value = nums[i]+nums[high-1]+nums[high];
			if (value < 0 && target > 0) {
				if (Math.abs(value-target) < Math.abs(closest-target)) {
					closest = value;
				}
				continue;
			}
    		while (low < high) {
    			value = nums[i]+nums[low]+nums[high];
				if (value-target == 0) {
					return target;
				}
    			if (Math.abs(value-target) < Math.abs(closest-target)) {
					closest = value;
				}
    			if (value > target) {
					while (low < high && nums[high-1] == nums[high]) {
						--high;
					}
					--high;
				} else {
					while (low <high && nums[low] == nums[low+1]) {
						++low;
					}
					++low;
				}
    		}
			while (i < nums.length-1 && nums[i] == nums[i+1]) {
				i++;
			}
    	}
    	return closest;
    }
}
