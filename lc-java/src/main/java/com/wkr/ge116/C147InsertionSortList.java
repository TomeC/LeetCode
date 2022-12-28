package com.wkr.ge116;

import com.wkr.ListNode;

import java.util.Arrays;

/**
 * @Description:
 * @date: 2022/12/28 15:54
 * @author: wangkun
 */
public class C147InsertionSortList {
    public static void main(String[] args) {
        ListNode.show(insertionSortList(ListNode.init(Arrays.asList(1,2,3,4))));
        ListNode.show(insertionSortList(ListNode.init(Arrays.asList(4,3,2,1))));
        ListNode.show(insertionSortList(ListNode.init(Arrays.asList(4,1,9,7,2,5))));
    }
    public static ListNode insertionSortList(ListNode head) {
        ListNode startNode = head, endNode = head;
        while (endNode.next != null) {
            ListNode sortNode = endNode.next;
            if (sortNode.val >= endNode.val) {
                endNode = endNode.next;
                continue;
            }
            endNode.next = endNode.next.next;
            if (sortNode.val <= startNode.val) {
                sortNode.next = startNode;
                startNode = sortNode;
                continue;
            }
            ListNode node = startNode;
            while (node != endNode) {
                if (sortNode.val > node.next.val) {
                    node = node.next;
                } else {
                    sortNode.next = node.next;
                    node.next = sortNode;
                    break;
                }
            }
        }
        return startNode;
    }
}
