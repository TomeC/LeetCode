package com.wkr.maxto50;
/*
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, 
 * only nodes itself can be changed.
 * */

import com.wkr.common.ListNode;

public class C24SwapNodesInPairs {
	public static void main(String[] args) {
		C24SwapNodesInPairs s = new C24SwapNodesInPairs();
		ListNode p = new ListNode(1);
		p.next = new ListNode(2);
		p.next.next = new ListNode(3);
		p.next.next.next = new ListNode(4);
		p.next.next.next.next = new ListNode(5);
		p.next.next.next.next.next = new ListNode(6);
		ListNode x = s.swapPairs(p);
		while (x != null) {
			System.out.println(x.val);
			x = x.next;
		}

	}
    public ListNode swapPairs(ListNode head) {
        ListNode p = head, pre, tmp;
        if (p != null && p.next != null) {
			tmp = p.next;
			p.next = tmp.next;
			tmp.next = p;
			head = tmp;
			pre = p;
			p = p.next;
		} else {
			return head;
		}
        while (p != null && p.next != null) {
        	tmp = p.next;
        	pre.next = tmp;
        	p.next = tmp.next;
        	tmp.next = p;
        	pre = p;
        	p = p.next;
        }
        return head;
    }
}
