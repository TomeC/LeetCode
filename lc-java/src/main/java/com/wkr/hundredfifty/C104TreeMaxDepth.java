package com.wkr.hundredfifty;

import com.wkr.TreeNode;

import java.util.LinkedList;

/**
 * @author 王锟
 * @Description:
 * @date 3/11/202110:29 AM
 */
public class C104TreeMaxDepth {

    public static void main(String[] args) {
        System.out.println(maxDepth2(null));

        TreeNode left = new TreeNode(2, null, new TreeNode(3));
        TreeNode right = new TreeNode(2,  new TreeNode(3), new TreeNode(4));
        TreeNode root = new TreeNode(1, left, right);
        //System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
    }

    public static int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode node = q.peekFirst();
            q.removeFirst();
            if (node == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                }
                max++;
                continue;
            }
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return max;
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        return 1+(left>right?left:right);
    }
}
