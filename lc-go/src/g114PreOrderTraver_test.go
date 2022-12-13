package src

import (
	"testing"
)

func preorderTraversal(root *TreeNode) []int {
	res := make([]int, 0)
	if root == nil {
		return res
	}
	res = append(res, root.Val)
	if root.Left != nil {
		res = append(res, preorderTraversal(root.Left)...)
	}
	if root.Right != nil {
		res = append(res, preorderTraversal(root.Right)...)
	}
	return res
}

// go test -v g114PreOrderTraver_test.go treeNode.go utils.go
func TestPreOrderTraver(t *testing.T) {
	res := preorderTraversal(NewTree([]int{1, 0, 2, 3}))
	if !checkArray(res, []int{1, 2, 3}) {
		t.FailNow()
	}

	res = preorderTraversal(NewTree([]int{}))
	if !checkArray(res, []int{}) {
		t.FailNow()
	}

	res = preorderTraversal(NewTree([]int{1}))
	if !checkArray(res, []int{1}) {
		t.FailNow()
	}

	res = preorderTraversal(NewTree([]int{1, 2}))
	if !checkArray(res, []int{1, 2}) {
		t.FailNow()
	}

	res = preorderTraversal(NewTree([]int{1, 0, 2}))
	if !checkArray(res, []int{1, 2}) {
		t.FailNow()
	}
}
