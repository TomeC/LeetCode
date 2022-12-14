package com.wkr;



import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 王锟
 * @Description:
 * @date 3/10/20216:14 PM
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static void show(TreeNode root) {
        System.out.println("show begin");
        if (root == null) {
            return;
        }
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        nodeDeque.add(root);
        nodeDeque.add(null);
        while (!nodeDeque.isEmpty()) {
            TreeNode node = nodeDeque.poll();
            if (node == null) {
                System.out.println("");
                if (nodeDeque.isEmpty()) {
                    break;
                }
                nodeDeque.add(null);
                continue;
            }
            System.out.print(node.val+" ");
            if (node.left != null) {
                nodeDeque.add(node.left);
            }
            if (node.right != null) {
                nodeDeque.add(node.right);
            }
        }
    }

    public static TreeNode init(ArrayList<Integer> inList) {
        if (inList == null || inList.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(inList.get(0));
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        int count = -1;
        int lack = 0;
        while (!treeNodeQueue.isEmpty()) {
            count++;
            TreeNode leaf = treeNodeQueue.poll();
            if (leaf == null) {
                lack+=2;
                continue;
            }

            int left = count*2+1-lack;
            int right = count*2+2-lack;
            if (left < inList.size() && inList.get(left) != null) {
                TreeNode leftNode = new TreeNode(inList.get(left));
                leaf.left = leftNode;
                treeNodeQueue.add(leftNode);
            } else {
                treeNodeQueue.add(null);
            }
            if (right < inList.size() && inList.get(right) != null) {
                TreeNode rightNode = new TreeNode(inList.get(right));
                leaf.right = rightNode;
                treeNodeQueue.add(rightNode);
            } else {
                treeNodeQueue.add(null);
            }
        }
        return root;
    }


    public static void main(String[] args) {
       TreeNode.show(TreeNode.init(new ArrayList(Arrays.asList(1,2,3,4,5))));
        TreeNode.show(TreeNode.init(new ArrayList(Arrays.asList(1,null,2,null,3,null,4,null,5,null,6))));
    }
}
