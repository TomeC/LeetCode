package com.wkr.maxto50;

/*
 * 26. Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * For example,
 * Given input array nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
 * It doesn't matter what you leave beyond the new length.
 * */

public class C26RemoveDuplicatesfromSortedArray {
	public static void main(String[] args) {
		C26RemoveDuplicatesfromSortedArray s = new C26RemoveDuplicatesfromSortedArray();
		int[] nums = {};
		System.out.println(s.removeDuplicates(nums));
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

    public int removeDuplicates(int[] nums) {
    	if (nums.length == 0) {
			return 0;
		}
    	int length = 1, diff = 1;
    	for (int i = 0; i+diff < nums.length; i++) {
			while (i+diff < nums.length && nums[i] == nums[i+diff]) {
				diff++;
			}
			if (i+diff < nums.length) {
				nums[i+1] = nums[i+diff];
				length++;
			}
		}
		return length;
    }
}
