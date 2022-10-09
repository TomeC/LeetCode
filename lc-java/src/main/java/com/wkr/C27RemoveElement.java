package com.wkr;

/*
 * 27. Remove Element
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * */

public class C27RemoveElement {
	public static void main(String[] args) {
		C27RemoveElement s = new C27RemoveElement();
		int[] nums = {2, 2, 3, 3, 4};
		System.out.println(s.removeElement(nums, 3));
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}

    public int removeElement2(int[] nums, int val) {
    	if (nums.length == 0) {
			return 0;
		}
        int length = nums.length;
        for (int i = 0; i < length; i++) {
			if (nums[i] == val) {
				while (length > 0 && nums[length-1] == val) {
					length--;
				}
				if (length > 1 && i < length) {
					nums[i] = nums[--length];
				}
			}
		}
        return length;
    }
    public int removeElement(int[] nums, int val) {
    	int length = 0;
    	for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[length++] = nums[i];
			}
		}
    	return length;
    }
}
