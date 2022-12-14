package com.wkr;

import java.util.*;

/**
 * @Description:
 * @date: 2022/12/14 11:45
 * @author: wangkun
 */
public class C114Flatten {
    public static void main(String[] args) {
//        TreeNode root = TreeNode.init(new ArrayList<>(Arrays.asList(1,2,5,3,4,null,6)));
//        TreeNode root = TreeNode.init(new ArrayList<>(Arrays.asList(0)));
        TreeNode root = TreeNode.init(null);
        TreeNode.show(root);
        flatten(root);
        TreeNode.show(root);
    }
    public static void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            if (root.left != null) {
                if (root.right != null) {
                    stack.push(root.right);
                }
                root.right = root.left;
                root.left = null;
                root = root.right;
            } else {
                if (root.right != null) {
                    root = root.right;
                } else {
                    if (stack.isEmpty()) {
                        break;
                    } else {
                        root.right = stack.pop();
                        root = root.right;
                    }
                }
            }
        }
    }
}
