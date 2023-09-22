package com.wkr.maxto50;

import com.wkr.common.ListNode;
import com.wkr.common.Utils;

import java.util.stream.IntStream;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @date 2023/9/22 16:36
 */
public class C02AddTwoNumbers {
    public static void main(String[] args) {
        Utils.check(addTwoNumbers(ListNode.init(IntStream.of(2,4,9)),
                        ListNode.init(IntStream.of(5,6,4,9))),
                ListNode.init(IntStream.of(7,0,4,0,1)));

        Utils.check(addTwoNumbers(ListNode.init(IntStream.of(2,4,3)),
                        ListNode.init(IntStream.of(5,6,4))),
                ListNode.init(IntStream.of(7,0,8)));

        Utils.check(addTwoNumbers(ListNode.init(IntStream.of(0)),
                        ListNode.init(IntStream.of(0))),
                ListNode.init(IntStream.of(0)));

        Utils.check(addTwoNumbers(ListNode.init(IntStream.of(9,9,9,9,9,9,9)),
                        ListNode.init(IntStream.of(9,9,9,9))),
                ListNode.init(IntStream.of(8,9,9,9,0,0,0,1)));
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = l1;
        ListNode pre = l1;
        while (l1 != null && l2 != null) {
            int sum = l1.val+l2.val+carry;
            carry = sum/10;
            l1.val = sum%10;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            pre.next = l2;
            l1 = l2;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum/10;
            l1.val = sum%10;
            pre = l1;
            l1 = l1.next;
        }
        if (carry != 0) {
            pre.next = new ListNode(carry);
        }
        return head;
    }
}
