package com.ben.Main;
/*
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together 
 * the nodes of the first two lists.
 * */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null, tmp = null;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				if (head == null) {
					head = tmp = new ListNode(l1.val);
				} else {
					tmp.next = new ListNode(l1.val);
					tmp = tmp.next;
				}
				l1 = l1.next;
			} else {
				if (head == null) {
					head = tmp = new ListNode(l2.val);
				} else {
					tmp.next = new ListNode(l2.val);
					tmp = tmp.next;
				}
				l2 = l2.next;
			}
		}
		while (l1 != null) {
			if (head == null) {
				head = tmp = new ListNode(l1.val);
			} else {
				tmp.next = new ListNode(l1.val);
				tmp = tmp.next;
			}
			l1 = l1.next;
		} 
		while (l2 != null) {
			if (head == null) {
				head = tmp = new ListNode(l2.val);
			} else {
				tmp.next = new ListNode(l2.val);
				tmp = tmp.next;
			}
			l2 = l2.next;
		}
		return head;
    }
}
public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode l1 = null;//new ListNode(1);
		//l1.next = new ListNode(3);
		ListNode l2 = null;//new ListNode(2);
		//l2.next = new ListNode(4);
		ListNode l = s.mergeTwoLists(l1, l2);
		while (l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}
}
