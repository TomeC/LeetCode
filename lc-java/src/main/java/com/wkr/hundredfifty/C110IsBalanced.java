package com.wkr.hundredfifty;

import com.wkr.TreeNode;
import com.wkr.Utils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description:
 * @date: 2023/1/3 17:24
 * @author: wangkun
 */
public class C110IsBalanced {
    public static void main(String[] args) {
        C110IsBalanced balanced = new C110IsBalanced();
        Utils.check(balanced.isBalanced(TreeNode.init(new ArrayList<>(Arrays.asList(3,9,20,null,null,15,7)))));
        Utils.check(!balanced.isBalanced(TreeNode.init(new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, null, null, 4, 4)))));

    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfsHeight(root) != -1;
    }
    public int dfsHeight(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        int hl = 0, hr = 0;
        if (root.left != null) {
            hl = dfsHeight(root.left);
            if (hl == -1) {
                return  -1;
            }
        }
        if (root.right != null) {
            hr = dfsHeight(root.right);
            if (hr == -1) {
                return  -1;
            }
        }
        if (Math.abs(hl-hr) > 1) {
            return -1;
        }
        return Math.max(hl, hr)+1;
    }
}
