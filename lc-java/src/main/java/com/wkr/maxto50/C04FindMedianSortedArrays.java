package com.wkr.maxto50;

import com.wkr.common.Utils;

/**
 * @author wkr
 * @Description: https://leetcode.cn/problems/median-of-two-sorted-arrays/
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * @date 2023/9/25 11:42
 */
public class C04FindMedianSortedArrays {
    public static void main(String[] args) {
        Utils.check(findMedianSortedArrays(new int[]{1,2}, new int[]{-1,3}), 1.5);
        Utils.check(findMedianSortedArrays(new int[]{3}, new int[]{1,2}), 2.0);
        Utils.check(findMedianSortedArrays(new int[]{1,}, new int[]{2,3,4}), 2.5);
        Utils.check(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 2.0);
        Utils.check(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 2.5);
        Utils.check(findMedianSortedArrays(new int[]{1}, new int[]{}), 1.0);
        Utils.check(findMedianSortedArrays(new int[]{1,2}, new int[]{}), 1.5);
        Utils.check(findMedianSortedArrays(new int[]{}, new int[]{1}), 1.0);
        Utils.check(findMedianSortedArrays(new int[]{}, new int[]{1,2}), 1.5);
    }
    // todo 实现时间复杂度 O(log (m+n))
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+ nums2.length;
        int left = 0, right = 0;
        int ia = 0, ib = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (ia < nums1.length && (ib >= nums2.length || nums1[ia] < nums2[ib])) {
                right = nums1[ia++];
            } else {
                right = nums2[ib++];
            }
        }
        return len%2==0?(left+right)/2.0:right;
    }
}
