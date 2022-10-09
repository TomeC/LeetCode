package com.wkr;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 王锟
 * @Description:
 * @date 3/13/202112:39 PM
 */
public class C113PathSumList {
    public static void main(String[] args) {
        System.out.println(pathSum(null, 1));

        TreeNode left = new TreeNode(3, null, new TreeNode(5));
        TreeNode right = new TreeNode(2,  new TreeNode(4), new TreeNode(6));
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(pathSum(root, 9));

        TreeNode r2 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(pathSum(r2, 3));

        TreeNode r3 = new TreeNode(1, null, null);
        System.out.println(pathSum(r3, 1));
    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        subPathSum(root, 0, targetSum, result, new LinkedList<>());
        return result;
    }

    public static void subPathSum(TreeNode root, int curSum, int targetSum, List<List<Integer>> path, LinkedList<Integer> curPath) {
//        System.out.println("sub path: "+curPath);
        if (root.left == null && root.right == null) {
            curPath.add(root.val);
            if (curSum+root.val == targetSum) {
                path.add(new LinkedList<>(curPath));
            }
            return;
        }
        curPath.add(root.val);
        if (root.left == null) {
            subPathSum(root.right,  curSum+root.val ,targetSum, path, curPath);
            curPath.removeLast();
        } else if (root.right == null) {
            subPathSum(root.left,  curSum+root.val ,targetSum, path, curPath);
            curPath.removeLast();
        } else {
            subPathSum(root.left,  curSum+root.val ,targetSum, path, curPath);
            curPath.removeLast();
            subPathSum(root.right,  curSum+root.val ,targetSum, path, curPath);
            curPath.removeLast();
        }
    }
}
