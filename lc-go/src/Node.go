package src

import (
	"container/list"
	"fmt"
)

type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

func NewNode(inList []int) *Node {
	if len(inList) == 0 {
		return nil
	}
	pos := -1
	lack := 0
	root := &Node{inList[0], nil, nil, nil}
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
		node := elem.Value.(*Node)
		left := pos*2 + 1 - lack
		right := pos*2 + 2 - lack
		if left < len(inList) && inList[left] != 0 {
			node.Left = &Node{inList[left], nil, nil, nil}
			nodeQueue.PushBack(node.Left)
		} else {
			nodeQueue.PushBack(nil)
		}
		if right < len(inList) && inList[right] != 0 {
			node.Right = &Node{inList[right], nil, nil, nil}
			nodeQueue.PushBack(node.Right)
		} else {
			nodeQueue.PushBack(nil)
		}
	}
	return root
}
func nodeDisplay(root *Node) {
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
		node := elem.Value.(*Node)
		if node.Next == nil {
			fmt.Print(node.Val, "[nil] ")
		} else {
			fmt.Print(node.Val, "[", node.Next.Val, "] ")
		}

		if node.Left != nil {
			nodeQueue.PushBack(node.Left)
		}
		if node.Right != nil {
			nodeQueue.PushBack(node.Right)
		}
	}
}
