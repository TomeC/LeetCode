package src

import (
	"testing"
)

func postorderTraversal(root *TreeNode) []int {
	res := make([]int, 0)
	if root == nil {
		return res
	}
	postOrder(root, &res)
	return res
}
func postOrder(root *TreeNode, res *([]int)) {
	if root.Left != nil {
		postOrder(root.Left, res)
	}
	if root.Right != nil {
		postOrder(root.Right, res)
	}
	*res = append(*res, root.Val)
}

func TestPostorderTraversal(t *testing.T) {
	if !checkArray(postorderTraversal(NewTree([]int{1, 0, 2, 3})), []int{3, 2, 1}) {
		t.FailNow()
	}
	if !checkArray(postorderTraversal(NewTree([]int{})), []int{}) {
		t.FailNow()
	}
	if !checkArray(postorderTraversal(NewTree([]int{1})), []int{1}) {
		t.FailNow()
	}
}
