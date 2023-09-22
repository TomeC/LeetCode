package com.wkr.maxto150;

import com.wkr.common.ListNode;
import com.wkr.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description:
 * @date: 2023/1/10 14:56
 * @author: wangkun
 */
public class C109SortedListToBST {
    public static void main(String[] args) {
        C109SortedListToBST toBST = new C109SortedListToBST();
        TreeNode.show(toBST.sortedListToBST(ListNode.init(new ArrayList<>(Arrays.asList(-10,-3,0,5,9)))));
    }
    public TreeNode sortedListToBST(ListNode head) {
        return dfsListToBST(head, null);
    }

    private TreeNode dfsListToBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        if (head.next == tail) {
            return new TreeNode(head.val);
        }
        ListNode slow = head, fast = head;
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (fast == tail || fast.next == tail || fast.next.next == tail) {
                break;
            }
            fast = fast.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = dfsListToBST(head, slow);
        root.right = dfsListToBST(slow.next, tail);
        return root;
    }
}
