package next

import (
	. "lc-go/src"
	"testing"
)

func sortedListToBST(head *ListNode) *TreeNode {
	return dfsSortList(head, nil)
}
func dfsSortList(head, last *ListNode) *TreeNode {
	if head == last {
		return nil
	}
	if head.Next == last {
		return &TreeNode{Val: head.Val, Left: nil, Right: nil}
	}

	slow := head
	fast := head
	for {
		slow = slow.Next
		fast = fast.Next
		if fast == last || fast.Next == last || fast.Next.Next == last {
			break
		}
		if fast != last {
			fast = fast.Next
		}

	}
	root := &TreeNode{Val: slow.Val, Left: nil, Right: nil}
	root.Left = dfsSortList(head, slow)
	root.Right = dfsSortList(slow.Next, last)
	return root
}

func TestSortListToBST(t *testing.T) {
	ShowTree(sortedListToBST(NewList([]int{-10, -3, 0, 5, 9})))
}
