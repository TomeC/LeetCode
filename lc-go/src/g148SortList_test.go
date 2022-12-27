package src

import "testing"

func sortList2(head *ListNode) *ListNode {
	max_val := 100000
	iHash := make([]int16, max_val*2)
	node := head
	for node != nil {
		iHash[node.Val+max_val] += 1
		node = node.Next
	}
	node = head
	for i := 0; i < max_val*2; i++ {
		for iHash[i] > 0 {
			iHash[i] -= 1
			node.Val = i - max_val
			node = node.Next
		}
	}
	return head
}
func sortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	return sortNode(head, nil)
}
func sortNode(head, tail *ListNode) *ListNode {
	if head == nil {
		return head
	}
	if head == tail || head.Next == tail {
		head.Next = nil
		return head
	}
	fast := head
	slow := head
	for fast != tail {
		slow = slow.Next
		fast = fast.Next
		if fast != tail {
			fast = fast.Next
		}

	}

	l := sortNode(head, slow)
	r := sortNode(slow, tail)
	return mergeList(l, r)
}
func mergeList(lNode, rNode *ListNode) *ListNode {
	if lNode == nil {
		return rNode
	}
	if rNode == nil {
		return lNode
	}
	head := lNode
	if lNode.Val > rNode.Val {
		head = rNode
		rNode = rNode.Next
	} else {
		lNode = lNode.Next
	}
	pre := head
	for lNode != nil && rNode != nil {
		if lNode.Val > rNode.Val {
			pre.Next = rNode
			pre = rNode
			rNode = rNode.Next
		} else {
			pre.Next = lNode
			pre = lNode
			lNode = lNode.Next
		}
	}
	if lNode == nil {
		pre.Next = rNode
	}
	if rNode == nil {
		pre.Next = lNode
	}
	return head
}
func TestSortList(t *testing.T) {
	displayList(sortList(NewList([]int{5, 4, 3, 2, 1})))
}
