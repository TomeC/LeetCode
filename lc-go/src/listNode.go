package src

type ListNode struct {
	Val  int
	Next *ListNode
}

func NewList(data []int) *ListNode {
	if len(data) == 0 {
		return nil
	}
	var root, tail *ListNode
	for _, k := range data {
		if root == nil {
			root = &ListNode{k, nil}
			tail = root
		} else {
			tail.Next = &ListNode{k, nil}
			tail = tail.Next
		}
	}
	return root
}
