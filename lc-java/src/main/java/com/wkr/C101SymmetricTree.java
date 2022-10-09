package com.wkr;


import java.util.LinkedList;

/**
 * @author 王锟
 * @Description:
 * @date 3/9/20212:28 PM
 */
public class C101SymmetricTree {
    public static void main(String[] args) throws Exception {
        C101SymmetricTree symmetricTree = new C101SymmetricTree();
        Utils.check(symmetricTree.isSymmetric(null), "null");

        TreeNode left = new TreeNode(2, null, new TreeNode(3));
        Utils.check(!symmetricTree.isSymmetric(left), "left is not symmetric");

        TreeNode right = new TreeNode(2,  new TreeNode(3), null);
        TreeNode root = new TreeNode(1, left, right);
        Utils.check(symmetricTree.isSymmetric(root) == true);

        TreeNode cl = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode cr = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        TreeNode t = new TreeNode(1, cl, cr);
        Utils.check(symmetricTree.isSymmetric(t));
    }
    boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> lTree = new LinkedList<>();
        lTree.add(root.left);
        LinkedList<TreeNode> rTree = new LinkedList<>();
        rTree.add(root.right);
        while (!lTree.isEmpty() && !rTree.isEmpty()) {
            if (lTree.peekFirst() != null && rTree.peekFirst() != null) {
                if (lTree.peekFirst().val != rTree.peekFirst().val) {
                    return false;
                }
                lTree.addLast(lTree.peekFirst().left);
                lTree.addLast(lTree.peekFirst().right);

                rTree.addLast(rTree.peekFirst().right);
                rTree.addLast(rTree.peekFirst().left);
            } else if (lTree.peekFirst() == null && rTree.peekFirst() == null) {

            } else {
                return false;
            }
            lTree.removeFirst();
            rTree.removeFirst();
        }
        if (!lTree.isEmpty() || !rTree.isEmpty()) {
            return false;
        }
        return true;
    }
}
