package com.wkr.maxto200;

import com.wkr.common.ListNode;
import com.wkr.common.Utils;

import java.util.Arrays;

/**
 * @Description:
 * @date: 2022/12/13 9:41
 * @author: wangkun
 */
public class C160GetIntersectionNode {
    public static void main(String[] args) {
        ListNode comNode = ListNode.init(Arrays.asList(1,2));
        ListNode nodeA = ListNode.init(Arrays.asList(3,4,5));
        nodeA.next.next.next = comNode;
        ListNode nodeB = ListNode.init(Arrays.asList(8,9));
        nodeB.next.next = comNode;
        C160GetIntersectionNode it = new C160GetIntersectionNode();
        Utils.check(it.getIntersectionNode(nodeA, nodeB), comNode);
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode na = headA, nb = headB;
        int la = 0, lb = 0;
        while (na != null) {
            la++;
            na = na.next;
        }
        while (nb != null) {
            lb++;
            nb = nb.next;
        }
        while (la > lb) {
            headA = headA.next;
            la--;
        }
        while (la < lb) {
            headB = headB.next;
            lb--;
        }
        while (System.identityHashCode(headA) != System.identityHashCode(headB)) {
            headA = headA.next;
            headB = headB.next;
            if (headA == null && headB == null) {
                return null;
            }
        }
        return headA;
    }
}
