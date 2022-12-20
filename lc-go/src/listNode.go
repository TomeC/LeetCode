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
func displayList(head *ListNode) {
	for head != nil {
		print(head.Val, "->")
		head = head.Next
	}
	println("nil")
}
