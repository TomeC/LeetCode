package com.wkr.maxto150;

import com.wkr.maxto200.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description:
 * @date: 2022/12/15 13:55
 * @author: wangkun
 */
public class C116Connect {
    public static void main(String[] args) {
        Node root = Node.init(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)));
        connect(root);
        Node.show(root);
    }
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        if (root.left != null) {
            connect(root.left);
        }
        if (root.right != null) {
            connect(root.right);
        }
        return root;
    }
}
