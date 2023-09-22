package com.wkr.common;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author wkr
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
    public static void check(int[] a1, int[] a2) {
        if (a1 == null && a2 == null) {
            System.out.println("success: null==null");
            return;
        }
        if (a1 == null || a2 == null) {
            System.out.println("fail:"+Arrays.toString(a1)+"!="+Arrays.toString(a2));
            return;
        }
        if (a1.length != a2.length) {
            System.out.println("fail: a1.length ("+a1.length +") != a2.length ("+a2.length+")");
            return;
        }
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                System.out.println("fail: "+"a1["+i+"] ("+a1[i]+") !=a2["+i+"] ("+a2[i]+")");
                return;
            }
        }
        System.out.println("success: "+ Arrays.toString(a1) +"=="+Arrays.toString(a2));
    }
    public static <T> void check(List<T> l1, List<T> l2, String message) {
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
        ListNode ha = a, hb = b;
        while (a != null && b != null) {
            if (a.val != b.val) {
                System.out.printf("fail: %s != %s\n", ListNode.toListString(ha), ListNode.toListString(hb));
                return;
            }
            a = a.next;
            b = b.next;
        }
        if (a == null && b == null) {
            System.out.printf("success: %s != %s\n", ListNode.toListString(ha), ListNode.toListString(hb));
            return;
        }
        System.out.printf("fail: %s != %s \n", ListNode.toListString(ha), ListNode.toListString(hb));
        return;
    }
    public static void check(String a, String b) {
        if (a == null && b == null) {
            System.out.println("null == null");
        } else if (a != null && b != null) {
            if (a.equals(b)) {
                System.out.println(a + " == " + b);
            } else {
                System.out.println(a + " != " + b);
            }

        } else {
            System.out.println(a + " != " + b);
        }
    }

    public static void main(String[] args) {
        check(new int[]{1, 2}, new int[]{1,2});
        check(new int[]{1, 2}, new int[]{1,1});
        check(new int[]{1, 2}, new int[]{1,2,3});
        check(new int[]{1, 2}, null);
    }
}
