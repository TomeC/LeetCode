package com.wkr.maxto150;

import com.wkr.common.TreeNode;
import com.wkr.common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @date: 2022/12/12 14:57
 * @author: wangkun
 */
public class C144PreorderTraversal {
    public static void main(String[] args) {
        C144PreorderTraversal traversal = new C144PreorderTraversal();
        Utils.check(traversal.preorderTraversal(TreeNode.init(new ArrayList<>(Arrays.asList(1,null,2,3)))), Arrays.asList(1,2,3), "1");
        Utils.check(traversal.preorderTraversal(TreeNode.init(new ArrayList<>(Arrays.asList()))), Arrays.asList(), "2");
        Utils.check(traversal.preorderTraversal(TreeNode.init(new ArrayList<>(Arrays.asList(1)))), Arrays.asList(1), "3");
        Utils.check(traversal.preorderTraversal(TreeNode.init(new ArrayList<>(Arrays.asList(1,2)))), Arrays.asList(1,2), "4");
        Utils.check(traversal.preorderTraversal(TreeNode.init(new ArrayList<>(Arrays.asList(1,null,2)))), Arrays.asList(1,2), "5");
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        if (root.left != null) {
            res.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            res.addAll(preorderTraversal(root.right));
        }
        return res;
    }
}
