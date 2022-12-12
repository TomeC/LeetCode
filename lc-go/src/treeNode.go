package src

import (
	"container/list"
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func New(inList []int) *TreeNode {
	if inList == nil || len(inList) == 0 {
		return nil
	}
	pos := -1
	lack := 0
	root := &TreeNode{inList[0], nil, nil}
	nodeQueue := list.New()
	nodeQueue.PushBack(root)
	for nodeQueue.Len() > 0 {
		pos++
		elem := nodeQueue.Front()
		nodeQueue.Remove(nodeQueue.Front())
		if elem.Value == nil {
			lack += 2
			continue
		}
		node := elem.Value.(*TreeNode)
		left := pos*2 + 1 - lack
		right := pos*2 + 2 - lack
		if left < len(inList) && inList[left] != 0 {
			node.Left = &TreeNode{inList[left], nil, nil}
			nodeQueue.PushBack(node.Left)
		} else {
			nodeQueue.PushBack(nil)
		}
		if right < len(inList) && inList[right] != 0 {
			node.Right = &TreeNode{inList[right], nil, nil}
			nodeQueue.PushBack(node.Right)
		} else {
			nodeQueue.PushBack(nil)
		}
	}
	return root
}
func show(root *TreeNode) {
	if root == nil {
		fmt.Println("empty tree")
		return
	}
	nodeQueue := list.New()
	nodeQueue.PushBack(root)
	nodeQueue.PushBack(nil)
	for nodeQueue.Len() > 0 {
		elem := nodeQueue.Front()
		nodeQueue.Remove(nodeQueue.Front())
		if elem.Value == nil {
			println("")
			if nodeQueue.Len() > 0 {
				nodeQueue.PushBack(nil)
				continue
			} else {
				break
			}
		}
		node := elem.Value.(*TreeNode)
		fmt.Print(node.Val, " ")
		if node.Left != nil {
			nodeQueue.PushBack(node.Left)
		}
		if node.Right != nil {
			nodeQueue.PushBack(node.Right)
		}
	}
}
