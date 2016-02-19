package com.nnk.container;

/*
 * 25. SReverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { 
    	val = x; 
    }
}
class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k < 1) {
			return head;
		}
		ListNode pHead = new ListNode(0);
		pHead.next = head;
		ListNode p = pHead;
		
		while (p != null) {
			p.next = reverse(p.next, k);
			for (int i = 0; i < k && p != null; i++) {
				p = p.next;
			}
		}
		return pHead.next;
	}

	private ListNode reverse(ListNode head, int k) {
		ListNode pEnd = head;
		while (k > 0 && pEnd != null) {
			pEnd = pEnd.next;
			k--;
		}
		if (k > 0) {
			return head;
		}
		ListNode pHead = pEnd, p = head;
		while (p != pEnd) {
			ListNode q = p.next;
			p.next = pHead;
			pHead = p;
			p = q;
		}
		return pHead;
	}
}

public class Main {
   public static void main(String[] args) {
	   ListNode head = createList(6);
	   Solution s = new Solution();
	   ListNode p = s.reverseKGroup(head, 2);
	   while (p != null) {
		   System.out.println(p.val);
		   p = p.next;
	   	}
	}
   private static ListNode createList(int k) {
	   ListNode head = null, p = null;
	   for (int i = 1; i < k+1; i++) {
		   if (head == null) {
			   head = p = new ListNode(i);
			   continue;
		   }
		   p.next = new ListNode(i);
		   p = p.next;
	   }
	   return head;
	}
}
