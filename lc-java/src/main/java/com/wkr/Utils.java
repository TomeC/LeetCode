package com.wkr;

import java.util.Iterator;
import java.util.List;

/**
 * @author 王锟
 * @Description:
 * @date 3/9/20212:41 PM
 */
public class Utils {
    public static void check(boolean flag, Object message) {
        if (!flag) {
            System.out.println("fail : "+message);
        } else {
            System.out.println("success");
        }
    }

    public static void check(boolean flag) {
        if (!flag) {
            System.out.println("fail");
        } else {
            System.out.println("success");
        }
    }
    public static void checkEqual(int[] a1, int[] a2) {
        if (a1 == null && a2 == null) {
            System.out.println("success");
            return;
        }
        if (a1 == null || a2 == null) {
            System.out.println("fail");
            return;
        }
        if (a1.length != a2.length) {
            System.out.println("fail");
            return;
        }
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                System.out.println("fail");
                return;
            }
        }
        System.out.println("success");
    }
    public static <T> void listEqual(List<T> l1, List<T> l2, String message) {
        if (l1 == null && l2 != null) {
            System.out.println("fail:"+message);
            return;
        }
        if (l2 == null && l1 != null) {
            System.out.println("fail:"+message);
            return;
        }
        if (l1.size() != l2.size()) {
            System.out.println("fail:"+message);
            return;
        }
        for (Iterator iterator1 = l1.iterator(), iterator2 = l2.iterator();
             iterator1.hasNext() && iterator2.hasNext();
             ) {
            if (!iterator1.next().equals(iterator2.next())) {
                System.out.println("fail:"+message);
                return;
            }
        }
        System.out.println("success:"+message);
    }
    public static void check(int a, int b) {
        if (a == b) {
            System.out.println(a + " == " + b);
        } else {
            System.out.println(a + " != " + b);
        }
    }
    public static void check(ListNode a, ListNode b) {
        if ((a == b) ||(a.val == b.val && a.next == b.next)) {
            System.out.println("success a==b");
            return;
        } else {
            System.out.println("fail: "+a.val+"!="+b.val);
        }
    }
}
