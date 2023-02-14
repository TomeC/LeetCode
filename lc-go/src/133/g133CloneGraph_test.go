package lc133

import (
	"fmt"
	"testing"
)

type Node struct {
	Val       int
	Neighbors []*Node
}

func cloneGraph(node *Node) *Node {
	if node == nil {
		return nil
	}
	cacheMap := make(map[int]*Node)
	vMap := make(map[int]bool)
	return dfsClone(node, &cacheMap, &vMap)
}
func dfsClone(node *Node, cacheMap *map[int]*Node, vMap *map[int]bool) *Node {
	var cNode *Node
	var ok bool
	if cNode, ok = (*cacheMap)[node.Val]; !ok {
		cNode = &Node{node.Val, nil}
	}

	(*cacheMap)[node.Val] = cNode
	(*vMap)[node.Val] = true
	for i := 0; i < len(node.Neighbors); i++ {
		tNode, ok := (*cacheMap)[node.Neighbors[i].Val]
		if !ok {
			tNode = &Node{node.Neighbors[i].Val, nil}
			(*cacheMap)[node.Neighbors[i].Val] = tNode
		}

		cNode.Neighbors = append(cNode.Neighbors, tNode)
		_, ok = (*vMap)[node.Neighbors[i].Val]
		if !ok {
			dfsClone(node.Neighbors[i], cacheMap, vMap)
		}
	}
	return cNode
}

// go test -v ./src/next/g105BuildTree_test.go
func TestCloneGraph(t *testing.T) {
	n1 := &Node{1, nil}
	n2 := &Node{2, nil}
	n3 := &Node{3, nil}
	n4 := &Node{4, nil}
	n1.Neighbors = append(n1.Neighbors, n2)
	n1.Neighbors = append(n1.Neighbors, n4)

	n2.Neighbors = append(n2.Neighbors, n1)
	n2.Neighbors = append(n2.Neighbors, n3)

	n3.Neighbors = append(n3.Neighbors, n2)
	n3.Neighbors = append(n3.Neighbors, n4)

	n4.Neighbors = append(n4.Neighbors, n1)
	n4.Neighbors = append(n4.Neighbors, n3)
	r := cloneGraph(n1)
	fmt.Println(r)
}
