package src

import (
	"testing"
)

func reorderList(head *ListNode) {
	if head == nil || head.Next == nil || head.Next.Next == nil {
		return
	}
	// mid pos
	slow := head
	fast := head
	var preSlow *ListNode
	for {
		preSlow = slow
		slow = slow.Next
		fast = fast.Next
		if fast != nil {
			fast = fast.Next
		}
		if fast == nil || fast.Next == nil {
			break
		}
	}
	preSlow.Next = nil
	// fmt.Println("mid pos", slow.Val)
	// reverse
	preSlow = slow
	slow = slow.Next
	preSlow.Next = nil
	for slow != nil {
		postSlow := slow.Next
		slow.Next = preSlow
		preSlow = slow
		slow = postSlow
	}
	// displayList(preSlow)
	// merge
	slow = preSlow
	for head != nil {
		postHead := head.Next
		postSlow := slow.Next

		head.Next = slow
		if postHead != nil {
			slow.Next = postHead
		}

		head = postHead
		slow = postSlow
	}
}

func TestReorderList(t *testing.T) {
	l := NewList([]int{1, 2, 3})
	reorderList(l)
	displayList(l)
}
