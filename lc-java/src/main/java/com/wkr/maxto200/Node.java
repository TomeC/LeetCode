package com.wkr.maxto200;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @date: 2022/12/15 13:57
 * @author: wangkun
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
    public static Node init(ArrayList<Integer> inList) {
        if (inList == null || inList.isEmpty()) {
            return null;
        }
        Node root = new Node(inList.get(0));
        Queue<Node> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        int count = -1;
        int lack = 0;
        while (!treeNodeQueue.isEmpty()) {
            count++;
            Node leaf = treeNodeQueue.poll();
            if (leaf == null) {
                lack+=2;
                continue;
            }

            int left = count*2+1-lack;
            int right = count*2+2-lack;
            if (left < inList.size() && inList.get(left) != null) {
                Node leftNode = new Node(inList.get(left));
                leaf.left = leftNode;
                treeNodeQueue.add(leftNode);
            } else {
                treeNodeQueue.add(null);
            }
            if (right < inList.size() && inList.get(right) != null) {
                Node rightNode = new Node(inList.get(right));
                leaf.right = rightNode;
                treeNodeQueue.add(rightNode);
            } else {
                treeNodeQueue.add(null);
            }
        }
        return root;
    }

    public static void show(Node root) {
        System.out.println("show begin");
        if (root == null) {
            return;
        }
        Deque<Node> nodeDeque = new LinkedList<>();
        nodeDeque.add(root);
        nodeDeque.add(null);
        while (!nodeDeque.isEmpty()) {
            Node node = nodeDeque.poll();
            if (node == null) {
                System.out.println("");
                if (nodeDeque.isEmpty()) {
                    break;
                }
                nodeDeque.add(null);
                continue;
            }
            System.out.print(node.val+"["+(node.next==null?null:node.next.val)+"] ");
            if (node.left != null) {
                nodeDeque.add(node.left);
            }
            if (node.right != null) {
                nodeDeque.add(node.right);
            }
        }
    }
}
