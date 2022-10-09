package com.wkr;

/**
 * @author 王锟
 * @Description:
 * @date 3/12/20219:54 AM
 */
public class C108Array2BST {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        System.out.println(C102TreeLevelOrder.levelOrder(sortedArrayToBST(nums)));

        nums = new int[]{1, 3};
        System.out.println(C102TreeLevelOrder.levelOrder(sortedArrayToBST(nums)));
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return subBuild(nums, 0, nums.length-1);
    }

    public static TreeNode subBuild(int[] nums, int start, int end) {
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if (start <= mid-1) {
            root.left = subBuild(nums, start, mid-1);
        }
        if (mid+1 <= end) {
            root.right = subBuild(nums, mid+1, end);
        }
        return root;
    }
}
