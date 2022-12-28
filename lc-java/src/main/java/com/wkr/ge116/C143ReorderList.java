package com.wkr.ge116;

import com.wkr.ListNode;

import java.util.Arrays;

/**
 * @Description:
 * @date: 2022/12/27 18:53
 * @author: wangkun
 */
public class C143ReorderList {
    public static void main(String[] args) {
        ListNode h4 = ListNode.init(Arrays.asList(1,2,3,4,5,6));
        reorderList(h4);
        ListNode.show(h4);

        ListNode h1 = ListNode.init(Arrays.asList(1,2,3));
        reorderList(h1);
        ListNode.show(h1);

        ListNode h2 = ListNode.init(Arrays.asList(1,2,3,4));
        reorderList(h2);
        ListNode.show(h2);

        ListNode h3 = ListNode.init(Arrays.asList(1,2,3,4,5));

        reorderList(h3);
        ListNode.show(h3);
    }
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head, fast = head, tail;
        while (true) {
            tail = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == null || fast.next == null) {
                break;
            }
        }
        tail.next = null;
        // reverse
        ListNode pre = slow;
        slow = slow.next;
        pre.next = null;
        ListNode post;
        while (slow != null) {
            post = slow.next;
            slow.next = pre;
            pre = slow;
            slow = post;
        }
        slow = pre;
//        ListNode.show(pre);

        // merge
        ListNode preHead, preSlow;
        while (head != null) {
            preHead = head.next;
            preSlow = slow.next;

            head.next = slow;
            if (preHead != null) {
                slow.next = preHead;
            }

            head = preHead;
            slow = preSlow;
        }
    }
}
