package com.wkr.maxto50;

import com.wkr.common.ListNode;

/*
 * 19. Remove Nth Node From End of List
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * */
public class C19RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);

		C19RemoveNthNodeFromEndOfList s = new C19RemoveNthNodeFromEndOfList();
		ListNode x = s.removeNthFromEnd(l, 1);
		while (x != null) {
			System.out.println(x.val);
			x = x.next;
		}
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tmp = head;
		int length = 0;
		while (tmp != null) {
			tmp = tmp.next;
			length++;
		}
		if (length == 1 && n == 1) {
			head = null;
			return head;
		}
		if (length == n) {
			head = head.next;
			return head;
		}
		tmp = head;
		while (tmp != null && n < length-1) {
			tmp = tmp.next;
			length--;
		}
		if (tmp != null) {
			if (tmp.next != null) {
				tmp.next = tmp.next.next;
			} else {
				tmp.next = null;
			}
			return head;
		}
		return null;
    }
}
