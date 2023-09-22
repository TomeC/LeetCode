package com.wkr.maxto150;

import com.wkr.common.TreeNode;
import com.wkr.common.Utils;

/**
 * @author wkr
 * @Description:
 * @date 3/13/202110:32 AM
 */
public class C112PathSum {
    public static void main(String[] args) throws Exception {
        TreeNode left = new TreeNode(3, null, new TreeNode(5));
        TreeNode right = new TreeNode(2,  new TreeNode(4), new TreeNode(6));
        TreeNode root = new TreeNode(1, left, right);

        Utils.check(!hasPathSum(null, 1), "1");

        Utils.check(!hasPathSum(root, 4), "4");
        Utils.check(hasPathSum(root, 7));
        Utils.check(hasPathSum(root, 9));
        Utils.check(!hasPathSum(root, 3));
        Utils.check(!hasPathSum(root, 6));

        TreeNode r2 = new TreeNode(1, new TreeNode(2), null);
        Utils.check(!hasPathSum(r2, 1));

        TreeNode r3 = new TreeNode(1, null, null);
        Utils.check(hasPathSum(r3, 1));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return subPathSum(root, 0, targetSum);
    }
    public static boolean subPathSum(TreeNode root, int curSum, int targetSum) {
        if (root.left == null && root.right == null) {
            return curSum+root.val == targetSum;
        }
        if (root.left == null) {
            return subPathSum(root.right,  curSum+root.val ,targetSum);
        } else if (root.right == null) {
            return subPathSum(root.left,  curSum+root.val ,targetSum);
        }
        return subPathSum(root.left,  curSum+root.val ,targetSum)
                || subPathSum(root.right,  curSum+root.val ,targetSum);
    }
}
