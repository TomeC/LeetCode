package com.wkr.ge116;

import com.wkr.ListNode;

import java.util.Arrays;

/**
 * @Description:
 * @date: 2022/12/19 14:09
 * @author: wangkun
 */
public class C148SortList {
    public static void main(String[] args) {
        C148SortList sortList = new C148SortList();
        ListNode.show(sortList.sortList(ListNode.init(Arrays.asList(1))));
        ListNode.show(sortList.sortList(ListNode.init(Arrays.asList(1,2))));
        ListNode.show(sortList.sortList(ListNode.init(Arrays.asList(1,2,3))));
        ListNode.show(sortList.sortList(ListNode.init(Arrays.asList(2,1))));
        ListNode.show(sortList.sortList(ListNode.init(Arrays.asList(3,2,1))));
        ListNode.show(sortList.sortList(ListNode.init(Arrays.asList(3,2,1,5,4))));

    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return subSort(head, null);
    }
    public ListNode subSort(ListNode head, ListNode tail) {
        if (head == tail) {
            System.out.println("head == tail");
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        return merge(subSort(head, slow), subSort(slow, tail));
    }
    public ListNode merge(ListNode lNode, ListNode rNode) {
        if (lNode == null) {
            return rNode;
        }
        if (rNode == null) {
            return lNode;
        }
        ListNode head = lNode;
        if (lNode.val > rNode.val) {
            head = rNode;
            rNode = rNode.next;
        } else {
            lNode = lNode.next;
        }
        ListNode pre = head;
        while (lNode != null && rNode != null) {
            if (lNode.val > rNode.val) {
                pre.next = rNode;
                pre = rNode;
                rNode = rNode.next;
            } else {
                pre.next = lNode;
                pre = lNode;
                lNode = lNode.next;
            }
        }
        if (lNode != null) {
            pre.next = lNode;
        }
        if (rNode != null) {
            pre.next = rNode;
        }
        return head;
    }
}
