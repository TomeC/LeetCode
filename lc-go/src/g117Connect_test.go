package src

import (
	"container/list"
	"testing"
)

func connect2(root *Node) *Node {
	if root == nil {
		return root
	}
	nq := list.New()
	nq.PushBack(root)
	nq.PushBack(nil)
	for nq.Len() > 0 {
		tmp := nq.Remove(nq.Front())
		if tmp == nil {
			if nq.Len() == 0 {
				break
			}
			nq.PushBack(nil)
			continue
		}
		node := tmp.(*Node)
		if nq.Front().Value != nil {
			node.Next = nq.Front().Value.(*Node)
		}

		if node.Left != nil {
			nq.PushBack(node.Left)
		}
		if node.Right != nil {
			nq.PushBack(node.Right)
		}
	}
	return root
}
func TestConnect2(t *testing.T) {
	node := NewNode([]int{2, 1, 3, 99, 7, 9, 1, 2, 0, 1, 99, 0, 0, 8, 8, 0, 0, 0, 0, 7})
	connect2(node)
	nodeDisplay(node)
}
