package com.wkr.maxto150;

import com.wkr.common.TreeNode;
import com.wkr.common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @date: 2022/12/12 20:04
 * @author: wangkun
 */
public class C145PostorderTraversal {
    public static void main(String[] args) {
        C145PostorderTraversal traversal = new C145PostorderTraversal();
        Utils.check(traversal.postorderTraversal(TreeNode.init(new ArrayList<>(Arrays.asList(1,null,2,3)))), Arrays.asList(3,2,1), "1");
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        postOrder(root, res);
        return res;
    }
    public void postOrder(TreeNode root, List<Integer> res) {
        if (root.left != null) {
            postOrder(root.left, res);
        }
        if (root.right != null) {
            postOrder(root.right, res);
        }
        res.add(root.val);
    }
}
