package com.wkr.ge116;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @date: 2022/12/30 16:15
 * @author: wangkun
 */
public class C138CopyRandomList {

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node chead = new Node(head.val);
        Node cnode = chead, thead = head.next;
        Map<Node, Node> nmap = new HashMap<>();
        nmap.put(head, chead);
        while (thead != null) {
            cnode.next = new Node(thead.val);
            cnode = cnode.next;
            nmap.put(thead, cnode);
            thead = thead.next;
        }
        cnode = chead;
        thead = head;
        while (thead != null) {
            cnode.random = nmap.get(thead.random);
            cnode = cnode.next;
            thead = thead.next;
        }
        return chead;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;

        n2.random = n1;
        Node head = copyRandomList(n1);
        Map<Node, Node> nmap = new HashMap<>();
        while (head != null) {
            if (head.random != null) {
                System.out.print(head.val+"["+head.random.val+"]->");
            } else {
                System.out.print(head.val+"[null]->");
            }
            head = head.next;
        }
        System.out.println("null");
    }

    static class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
