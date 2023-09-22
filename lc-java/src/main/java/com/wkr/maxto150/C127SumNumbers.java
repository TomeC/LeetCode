package com.wkr.maxto150;

import com.wkr.common.TreeNode;
import com.wkr.common.Utils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description:
 * @date: 2022/12/17 8:31
 * @author: wangkun
 */
public class C127SumNumbers {
    public static void main(String[] args) {
        Utils.check(sumNumbers(TreeNode.init(new ArrayList<>(Arrays.asList(1,2,3)))), 25);
        Utils.check(sumNumbers(TreeNode.init(new ArrayList<>(Arrays.asList(1,2,3,null,4)))), 137);
        Utils.check(sumNumbers(TreeNode.init(new ArrayList<>(Arrays.asList(4,9,0,5,1)))), 1026);
    }
    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return calSum(root, 0);
    }
    public static int calSum(TreeNode node, int presum) {

        int sum = presum*10+node.val;
        System.out.println(node.val+":"+sum);
        if (node.left == null && node.right == null) {
            return sum;
        }
        int leftSum = node.left != null?calSum(node.left, sum):0;
        int rightSum = node.right != null?calSum(node.right, sum):0;
        System.out.println("left:"+leftSum+" right:"+rightSum);
        return leftSum+rightSum;
    }
}
