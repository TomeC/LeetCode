package src

import "testing"

func insertionSortList(head *ListNode) *ListNode {
	startNode := head
	endNode := head
	for endNode.Next != nil {
		sortNode := endNode.Next
		if sortNode.Val > endNode.Val {
			endNode = endNode.Next
			continue
		}
		endNode.Next = endNode.Next.Next
		if sortNode.Val <= startNode.Val {
			sortNode.Next = startNode
			startNode = sortNode
			continue
		}
		pre := startNode
		for pre != endNode {
			if sortNode.Val > pre.Next.Val {
				pre = pre.Next
			} else {
				node := pre.Next
				pre.Next = sortNode
				sortNode.Next = node
				break
			}
		}

	}
	return startNode
}
func TestInsertionSortList(t *testing.T) {
	displayList(insertionSortList(NewList([]int{4, 2, 1, 3})))
	displayList(insertionSortList(NewList([]int{1, 2, 3})))
	displayList(insertionSortList(NewList([]int{3, 2, 1})))
	displayList(insertionSortList(NewList([]int{4, 3, 5, 1, 8})))
}
