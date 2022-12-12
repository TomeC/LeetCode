package com.wkr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * @date: 2022/12/5 19:34
 * @author: wangkun
 */
public class C111MinDepth {
    public static void main(String[] args) {
        Utils.check(minDepth(TreeNode.init(new ArrayList<>(Arrays.asList(3,9,20,null,null,15,7)))), 2);
        Utils.check(minDepth(TreeNode.init(new ArrayList<>(Arrays.asList(2,null,3,null,4,null,5,null,6)))), 5);
    }
    public static int minDepth(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        deque.addLast(root);
        deque.addLast(null);
        int level = 0;
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node == null) {
                level++;
                if (deque.isEmpty()) {
                    return level;
                } else {
                    deque.addLast(null);
                }
                continue;
            }
            if (node.left == null && node.right == null) {
                return ++level;
            }
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
        }
        return level;
    }
}
