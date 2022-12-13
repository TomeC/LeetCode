package com.wkr;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @date: 2022/10/9 19:49
 * @author: wangkun
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    public static ListNode init(List<Integer> inList) {
        ListNode head = null, tail = null;
        for (Integer i : inList) {
            ListNode node = new ListNode(i);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }
    public static void show(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode.show(ListNode.init(Arrays.asList(1,2,3)));
        ListNode.show(ListNode.init(Arrays.asList()));
    }
}
