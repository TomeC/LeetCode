package src

import "testing"

func detectCycle(head *ListNode) *ListNode {
	slow := head
	fast := head
	for {
		if fast == nil || fast.Next == nil || fast.Next.Next == nil {
			return nil
		}
		fast = fast.Next.Next
		slow = slow.Next
		if slow == fast {
			break
		}
	}
	slow = head
	for slow != fast {
		slow = slow.Next
		fast = fast.Next
	}
	return slow
}

func TestDeleteCycle(t *testing.T) {
	root := NewList([]int{3, 2, 0})
	root.Next.Next.Next = root.Next
	if detectCycle(root).Val != 2 {
		t.FailNow()
	}
	root.Next.Next.Next = root
	if detectCycle(root).Val != 3 {
		t.FailNow()
	}
}
