package src

import (
	"container/list"
	"testing"
)

func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	nodeQueue := list.New()
	nodeQueue.PushBack(root)
	nodeQueue.PushBack(nil)
	depth := 0
	for nodeQueue.Len() > 0 {
		elem := nodeQueue.Front()
		nodeQueue.Remove(elem)
		if elem.Value == nil {
			depth++
			if nodeQueue.Len() > 0 {
				nodeQueue.PushBack(nil)
				continue
			} else {
				break
			}

		}
		node := elem.Value.(*TreeNode)
		if node.Left == nil && node.Right == nil {
			depth++
			break
		}
		if node.Left != nil {
			nodeQueue.PushBack(node.Left)
		}
		if node.Right != nil {
			nodeQueue.PushBack(node.Right)
		}
	}
	return depth
}

//go test -v g111MinDepth_test.go treeNode.go
func TestMinDepth(t *testing.T) {
	inList := []int{3, 9, 20, 0, 0, 15, 7}
	tree := NewTree(inList[:])
	//ShowTree(tree)
	if minDepth(tree) != 2 {
		t.FailNow()
	}

	inList = []int{2, 0, 3, 0, 4, 0, 5, 0, 6}
	tree = NewTree(inList[:])
	// ShowTree(tree)
	if minDepth(tree) != 5 {
		t.FailNow()
	}
}
