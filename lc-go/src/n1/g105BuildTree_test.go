package next

import (
	. "lc-go/src"
	"testing"
)

func buildTree(preorder []int, inorder []int) *TreeNode {
	inMap := make(map[int]int)
	for i := 0; i < len(inorder); i++ {
		inMap[inorder[i]] = i
	}
	return dfsBuild(preorder, 0, len(preorder), 0, inMap)
}
func dfsBuild(preorder []int, preLeft int, preRight int, inLeft int, inMap map[int]int) *TreeNode {
	root := &TreeNode{preorder[preLeft], nil, nil}
	inRootPos := inMap[preorder[preLeft]]
	leftLen := inRootPos - inLeft
	if preLeft+1 < preLeft+leftLen+1 {
		root.Left = dfsBuild(preorder, preLeft+1, preLeft+leftLen+1, inLeft, inMap)
	}
	if preLeft+leftLen+1 < preRight {
		root.Right = dfsBuild(preorder, preLeft+leftLen+1, preRight, inRootPos+1, inMap)
	}
	return root
}

func TestBuildTree(t *testing.T) {
	ShowTree(buildTree([]int{1, 2, 3}, []int{3, 2, 1}))
	ShowTree(buildTree([]int{3, 9, 20, 15, 7}, []int{9, 3, 15, 20, 7}))
}
