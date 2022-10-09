package com.wkr;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 王锟
 * @Description:
 * @date 3/11/202110:03 AM
 */
public class C103ZigzagLevelOrder {
    public static void main(String[] args) {
        System.out.println(zigzagLevelOrder(null));

        TreeNode left = new TreeNode(2, null, new TreeNode(4));
        TreeNode right = new TreeNode(3,  new TreeNode(5), null);
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(zigzagLevelOrder(root));
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        LinkedList<Integer> lineResult = new LinkedList<>();
        boolean seqFlag = true;
        while (!q.isEmpty()) {
            TreeNode node = q.peekFirst();
            q.removeFirst();
            if (node == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                }
                seqFlag = !seqFlag;
                result.add(lineResult);
                lineResult = new LinkedList<>();
                continue;
            }
            if (seqFlag) {
                lineResult.add(node.val);
            } else {
                lineResult.addFirst(node.val);
            }

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
