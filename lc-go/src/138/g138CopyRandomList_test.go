package lc138

import (
	"testing"
)

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

func copyRandomList(head *Node) *Node {
	if head == nil {
		return nil
	}
	chead := &Node{head.Val, nil, nil}
	nmap := make(map[*Node]*Node)
	nmap[head] = chead
	cnode := chead
	tnode := head.Next
	for tnode != nil {
		cnode.Next = &Node{tnode.Val, nil, nil}
		cnode = cnode.Next

		nmap[tnode] = cnode
		tnode = tnode.Next
	}
	cnode = chead
	tnode = head
	for tnode != nil {
		cnode.Random = nmap[tnode.Random]
		tnode = tnode.Next
		cnode = cnode.Next
	}
	return chead
}

func TestCopyRandomList(t *testing.T) {
	n1 := &Node{1, nil, nil}
	n2 := &Node{2, nil, nil}
	n3 := &Node{3, nil, nil}
	n1.Next = n2
	n2.Next = n3
	n1.Random = n3
	n2.Random = n3
	head := copyRandomList(n1)
	for head != nil {
		if head.Random != nil {
			print(head.Val, "[", head.Random.Val, "]->")
		} else {
			print(head.Val, "[nil]->")
		}

		head = head.Next
	}
	println("nil")
}
