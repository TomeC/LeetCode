package com.wkr.hundredfifty;

import com.wkr.ListNode;
import com.wkr.Utils;

import java.util.Arrays;

/**
 * @Description:
 * @date: 2022/12/20 12:01
 * @author: wangkun
 */
public class C142DetectCycle {
    public static void main(String[] args) {
        ListNode l = ListNode.init(Arrays.asList(1,2,3));
        Utils.check(detectCycle(l), null);
        l.next.next = l.next;
        Utils.check(detectCycle(l).val, 2);
        l.next.next = l;
        Utils.check(detectCycle(l).val, 1);
    }
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
