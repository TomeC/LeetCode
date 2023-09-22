package com.wkr.maxto150;

import com.wkr.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @date: 2023/1/10 16:42
 * @author: wangkun
 */
public class C106BuildTree {
    public static void main(String[] args) {
        C106BuildTree buildTree = new C106BuildTree();
        TreeNode.show(buildTree.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return dfsBuildTree(inMap, 0, postorder, 0, postorder.length-1);
    }

    private TreeNode dfsBuildTree(Map<Integer, Integer> inMap, int inLeft, int[] postorder, int pLeft, int pRight) {
        if (pLeft > pRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pRight]);
        int inRootPos = inMap.get(postorder[pRight]);
        int leftLen = inRootPos-inLeft;
        root.left = dfsBuildTree(inMap, inLeft, postorder, pLeft, pLeft+leftLen-1);
        root.right = dfsBuildTree(inMap, inRootPos+1, postorder, pLeft+leftLen, pRight-1);
        return root;
    }
}
