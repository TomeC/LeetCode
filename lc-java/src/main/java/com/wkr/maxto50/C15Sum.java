package com.wkr.maxto50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
 * 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 *
 *  A solution set is:
 *  (-1, 0, 1)
 *  (-1, -1, 2)
 * */
public class C15Sum {
	public static void main(String[] args) {
		int [] arr = {34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
		Arrays.sort(arr);
		IntStream.of(arr).boxed().forEach(i -> System.out.print(i+" "));
		C15Sum s = new C15Sum();
		int []str = {-1, -1, 0, 1, 2, 3};
		System.out.println(s.threeSum(str));
	}
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> lli = new ArrayList<>();
    	if (nums.length < 3) {
			return lli;
		}
    	Arrays.sort(nums);
    	int low, high;
    	for (int i = 0; i < nums.length-2; i++) {
    		low = i+1;
    		high = nums.length-1;

			if (nums[i]+nums[low]+nums[low+1] > 0) {
				return lli;
			}
			if (nums[i]+nums[high-1]+nums[high] < 0) {
				continue;
			}
    		while (low < high) {
	    		int value = nums[i]+nums[low]+nums[high];
				if (value == 0) {
					List<Integer> li = new ArrayList<>(3);
					li.add(nums[i]);
					li.add(nums[low]);
					li.add(nums[high]);
					lli.add(li);
					while (low < high && nums[low] == nums[low+1]) {
						++low;
					}
					while (high > low && nums[high] == nums[high-1]) {
						--high;
					}
					++low;
					--high;
				} else if (value < 0) {
					while (low < high && nums[low] == nums[low+1]) {
						++low;
					}
					++low;
				} else {
					while (high > low && nums[high] == nums[high-1]) {
						--high;
					}
					--high;
				}
    		}
    		while (i < nums.length-2 && nums[i] == nums[i+1]) {
				++i;
			}
    	}
    	return lli;
    }
}
