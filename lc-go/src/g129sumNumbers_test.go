package src

import "testing"

func sumNumbers(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return calSum(root, 0)
}
func calSum(node *TreeNode, preSum int) int {
	sum := preSum*10 + node.Val
	if node.Left == nil && node.Right == nil {
		return sum
	}
	left := 0
	right := 0
	if node.Left != nil {
		left = calSum(node.Left, sum)
	}
	if node.Right != nil {
		right = calSum(node.Right, sum)
	}
	return left + right
}
func TestSumNumbers(t *testing.T) {
	if sumNumbers(NewTree([]int{1, 2, 3})) != 25 {
		t.FailNow()
	}
	if sumNumbers(NewTree([]int{4, 9, 1, 5, 1})) != 1027 {
		t.FailNow()
	}
}
