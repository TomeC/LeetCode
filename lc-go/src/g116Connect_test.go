package src

import "testing"

func connect(root *Node) *Node {
	if root == nil {
		return nil
	}
	if root.Left != nil && root.Right != nil {
		root.Left.Next = root.Right
	}
	if root.Next != nil && root.Right != nil {
		root.Right.Next = root.Next.Left
	}
	if root.Left != nil {
		connect(root.Left)
	}
	if root.Right != nil {
		connect(root.Right)
	}
	return root
}
func TestConnect(t *testing.T) {
	root := NewNode([]int{1, 2, 3, 4, 5, 6, 7})
	connect(root)
	nodeDisplay(root)
}
