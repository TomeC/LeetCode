package com.wkr.hundredfifty;

import com.wkr.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @date: 2023/1/9 16:02
 * @author: wangkun
 */
public class C105BuildTree {
    public static void main(String[] args) {
        C105BuildTree buildTree = new C105BuildTree();
        TreeNode.show(buildTree.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return dfsBuild(preorder, 0, preorder.length, 0, inMap);
    }

    private TreeNode dfsBuild(int[] preorder, int preLeft, int preRight, int inLeft, Map<Integer, Integer> inMap) {
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inRootPos = inMap.get(root.val);
        int leftLen = inRootPos-inLeft;
        if (preLeft+1 < preLeft+leftLen+1) {
            root.left = dfsBuild(preorder,preLeft+1,preLeft+leftLen+1, inLeft, inMap);
        }
        if (preLeft+leftLen+1 < preRight) {
            root.right = dfsBuild(preorder,preLeft+leftLen+1, preRight, inRootPos+1, inMap);
        }
        return root;
    }
}
