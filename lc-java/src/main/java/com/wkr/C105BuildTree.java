package com.wkr;

/**
 * @author 王锟
 * @Description:
 * @date 3/11/20213:16 PM
 */
public class C105BuildTree {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[preorder.length-1]);
//        root.left(buildTree(Arrays.copyOfRange(preorder, 0, preorder.length-1), Arrays.copyOfRange(inorder, 0,inorder.length-1)));
//        root.right(buildTree());
        return root;
    }
}
