package com.wkr.hundredfifty;

import com.wkr.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 王锟
 * @Description:
 * @date 3/10/20215:59 PM
 */
public class C102TreeLevelOrder {
    public static void main(String[] args) {
        System.out.println(levelOrder(null));

        TreeNode left = new TreeNode(2, null, new TreeNode(3));
        TreeNode right = new TreeNode(2,  new TreeNode(3), new TreeNode(4));
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(levelOrder(root));
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> lineResult = new LinkedList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.peekFirst();
            q.removeFirst();
            if (node == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                }
                result.add(lineResult);
                lineResult = new LinkedList<>();
                continue;
            }
            lineResult.add(node.val);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return result;
    }

}
