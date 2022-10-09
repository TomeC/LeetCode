package com.wkr;

/**
 * @author 王锟
 * @Description:
 * @date 3/10/20216:14 PM
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static void show(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);

    }
}
