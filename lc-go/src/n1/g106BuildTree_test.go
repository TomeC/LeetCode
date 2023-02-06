package next

import (
	. "lc-go/src"
	"testing"
)

func buildTree2(inorder []int, postorder []int) *TreeNode {
	inMap := make(map[int]int)
	for i := 0; i < len(inorder); i++ {
		inMap[inorder[i]] = i
	}
	return dfsBuild2(0, postorder, 0, len(postorder)-1, inMap)
}
func dfsBuild2(inLeft int, postorder []int, pLeft int, pRight int, inMap map[int]int) *TreeNode {
	root := &TreeNode{postorder[pRight], nil, nil}
	inRootPos := inMap[root.Val]
	leftLen := inRootPos - inLeft
	if pLeft <= pLeft+leftLen-1 {
		root.Left = dfsBuild2(inLeft, postorder, pLeft, pLeft+leftLen-1, inMap)
	}
	if pLeft+leftLen <= pRight-1 {
		root.Right = dfsBuild2(inRootPos+1, postorder, pLeft+leftLen, pRight-1, inMap)
	}
	return root
}
func TestBuildTree2(t *testing.T) {
	ShowTree(buildTree2([]int{9, 3, 15, 20, 7}, []int{9, 15, 7, 20, 3}))
}
