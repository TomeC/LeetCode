package com.wkr.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description:
 * @date: 2022/10/9 19:49
 * @author: wangkun
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }
    public static ListNode init(IntStream intStream) {
        return init(intStream.boxed().collect(Collectors.toList()));
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
        System.out.println(toListString(head));
    }
    public static String toListString(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val);
            builder.append("->");
            head = head.next;
        }
        builder.append("null");
        return builder.toString();
    }

    public static void main(String[] args) {
        ListNode.show(ListNode.init(Arrays.asList(1,2,3)));
        ListNode.show(ListNode.init(Arrays.asList()));
    }
}
