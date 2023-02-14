package com.wkr.ge116;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @date: 2023/2/13 19:11
 * @author: wangkun
 */

public class C133CloneGraph {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n1);
        n4.neighbors.add(n3);
        C133CloneGraph graph = new C133CloneGraph();
        Node node = graph.cloneGraph(n1);
        System.out.println(node);
    }
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        return dfsCloneGraph(node, new HashMap<>(), new HashMap<>());
    }
    Node dfsCloneGraph(Node node, Map<Integer, Node> cacheNode, Map<Integer, Boolean> vNode) {
        Node cNode;
        if (cacheNode.containsKey(node.val)) {
            cNode = cacheNode.get(node.val);
        } else {
            cNode = new Node(node.val);
            cacheNode.put(node.val, cNode);
        }
        vNode.put(node.val, true);
        for (int i = 0; i < node.neighbors.size(); i++) {
            if (cacheNode.containsKey(node.neighbors.get(i).val)) {
                cNode.neighbors.add(cacheNode.get(node.neighbors.get(i).val));
            } else {
                Node tNode = new Node(node.neighbors.get(i).val);
                cNode.neighbors.add(tNode);
                cacheNode.put(tNode.val, tNode);
            }
            if (!vNode.containsKey(node.neighbors.get(i).val)) {
                dfsCloneGraph(node.neighbors.get(i), cacheNode, vNode);
            }
        }
        return cNode;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
