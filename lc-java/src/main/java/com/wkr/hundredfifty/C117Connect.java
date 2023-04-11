package com.wkr.hundredfifty;

import com.wkr.twohundred.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @date: 2022/12/16 17:58
 * @author: wangkun
 */
public class C117Connect {
    public static void main(String[] args) {
        Node root = Node.init(new ArrayList<>(Arrays.asList(2,1,3,0,7,9,1,2,null,1,0,null,null,8,8,null,null,null,null,7)));
        connect(root);
        Node.show(root);
    }
    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> nq = new LinkedList<>();
        nq.add(root);
        nq.add(null);
        while (!nq.isEmpty()) {
            Node node = nq.poll();
            if (node == null) {
                if (nq.isEmpty()) {
                    break;
                }
                nq.add(null);
                continue;
            }
            node.next = nq.peek();
            if (node.left != null) {
                nq.add(node.left);
            }
            if (node.right != null) {
                nq.add(node.right);
            }
        }
        return root;
    }
}
