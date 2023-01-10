package src

import (
	"container/list"
	"testing"
)

func flatten(root *TreeNode) {
	s := list.New()
	for root != nil {
		if root.Left != nil {
			if root.Right != nil {
				s.PushBack(root.Right)
			}
			root.Right = root.Left
			root.Left = nil
			root = root.Right
		} else {
			if root.Right != nil {
				root = root.Right
			} else {
				if s.Len() > 0 {
					root.Right = s.Remove(s.Back()).(*TreeNode)
					root = root.Right
				} else {
					break
				}
			}
		}
	}
}
func TestFlatten(t *testing.T) {
	tree := NewTree([]int{1, 2, 5, 3, 4, 0, 6})
	flatten(tree)
	ShowTree(tree)
}
