package com.wkr;
/*
 * 23. Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * */

public class C23MergeKSortedLists {
	public static void main(String[] args) {
		C23MergeKSortedLists s = new C23MergeKSortedLists();
		ListNode []p = new ListNode[2];
		p[0] = null;//new ListNode(1);
		//p[0].next = new ListNode(5);
		p[1] = null;//new ListNode(3);
		//p[2] = new ListNode(2);
		ListNode x = s.mergeKLists(p);
		while (x != null) {
			System.out.println(x.val);
			x = x.next;
		}

	}

    public ListNode mergeKLists(ListNode[] lists) {
    	if (lists.length == 0) {
			return null;
		}
    	ListNode p;
    	int len = lists.length;
    	while (len > 1) {
    		p = Merge2List(lists[0], lists[len-1]);
    		lists[0] = p;
    		--len;
    	}
		return lists[0];
    }
    /*
     * param p and q is not null
     * */
    private ListNode Merge2List(ListNode p, ListNode q) {
    	ListNode head = null, pointer = null;
    	if (p == null && q == null) {
			return head;
		} else if (p == null) {
			return q;
		} else if (q == null) {
			return p;
		}
    	if (p.val > q.val) {
			head = pointer = new ListNode(q.val);
			q = q.next;
		} else {
			head = pointer = new ListNode(p.val);
			p = p.next;
		}
    	while (p != null && q != null) {
    		if (p.val > q.val) {
				pointer.next = new ListNode(q.val);
				q = q.next;
				
			} else {
				pointer.next = new ListNode(p.val);
				p = p.next;
			}
    		pointer = pointer.next;
    	}
    	while (p != null) {
    		pointer.next = new ListNode(p.val);
    		pointer = pointer.next;
    		p = p.next;
		}
    	while (q != null) {
    		pointer.next = new ListNode(q.val);
    		pointer = pointer.next;
    		q = q.next;
    	}
    	return head;
    }
}
