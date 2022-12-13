package src

import (
	"testing"
)

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	if headA == nil || headB == nil {
		return nil
	}
	na := headA
	nb := headB
	la := 0
	lb := 0
	for na != nil {
		la++
		na = na.Next
	}
	for nb != nil {
		lb++
		nb = nb.Next
	}
	for la > lb {
		la--
		headA = headA.Next
	}
	for lb > la {
		lb--
		headB = headB.Next
	}
	for headA != headB {
		headA = headA.Next
		headB = headB.Next
		if headA == nil && headB == nil {
			return nil
		}
	}
	return headA
}
func TestGetIntersectionNode(t *testing.T) {
	comNode := NewList([]int{1, 2})
	headA := NewList([]int{3, 4})
	headA.Next.Next = comNode
	headB := NewList([]int{5})
	headB.Next = comNode
	if getIntersectionNode(headA, headB) != comNode {
		t.FailNow()
	}
}
