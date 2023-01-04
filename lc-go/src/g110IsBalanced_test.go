package src

import (
	"testing"
)

func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}
	if dfsBalanced(root) == -1 {
		return false
	}
	return true
}
func dfsBalanced(root *TreeNode) int {
	if root.Left == nil && root.Right == nil {
		return 1
	}
	var hl, hr int
	if root.Left != nil {
		hl = dfsBalanced(root.Left)
		if hl == -1 {
			return -1
		}
	}
	if root.Right != nil {
		hr = dfsBalanced(root.Right)
		if hr == -1 {
			return -1
		}
	}

	if hl-hr > 1 || hl-hr < -1 {
		return -1
	}
	if hl > hr {
		return hl + 1
	} else {
		return hr + 1
	}
}

func TestIsBalanced(t *testing.T) {
	if isBalanced(NewTree([]int{1, 2, 2, 3, 3, 0, 0, 4, 4})) == true {
		t.FailNow()
	}
	if isBalanced(NewTree([]int{3, 9, 20, 0, 0, 15, 7})) == false {
		t.FailNow()
	}
}
