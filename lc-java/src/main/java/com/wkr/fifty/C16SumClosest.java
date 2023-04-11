package com.wkr.fifty;
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
    public int threeSumClosest(int[] nums, int target) {
    	// 三重循环的方式会超时了，换一个
    	int closest = nums[0]+nums[1]+nums[2];
    	int low, high, value = 0;
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length-2; i++) {
    		if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
    		low = i+1;
    		high = nums.length-1;
    		while (low < high) {
    			value = nums[i]+nums[low]+nums[high];
    			if (Math.abs(value-target) < Math.abs(closest-target)) {
					closest = value;
				}
    			if (value > target) {
					while (low < high && nums[high-1] == nums[high]) --high;
					--high;
				} else if (value < target) {
					while (low <high && nums[low] == nums[low+1]) ++low;
					++low;
				} else {
					return closest;
				}
    		}
    	}
    	return closest;
    }
}
