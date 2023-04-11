package com.wkr.hundredfifty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王锟
 * @Description:
 * @date 8/12/202111:17 AM
 *    1
 *   1 1
 *  1 2 1
 * 1 3 3 1
 */
public class C118yanghui {
    public static void main(String[] args) {
        C118yanghui solution = new C118yanghui();
        showRes(solution.generate(1));
        showRes(solution.generate(2));
        showRes(solution.generate(3));
        showRes(solution.generate(4));
        showRes(solution.generate(10));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        if (numRows < 1) {
            return res;
        }
        List<Integer> f1 = new ArrayList<>(1);
        f1.add(1);
        res.add(f1);
        for (int line = 2; line < numRows+1; line++) {
            List<Integer> l = new ArrayList<>(line);
            for (int p = 1; p < line+1; p++) {
                if (p == 1 || p == line) {
                    l.add(1);
                } else {
                    l.add(res.get(line-2).get(p-2)+res.get(line-2).get(p-1));
                }
            }
            res.add(l);
        }
        return res;
    }

    public static void showRes(List<List<Integer>> res) {
        System.out.println("sanjiao:"+ res.size()+"\n");
        for (List<Integer> l : res) {
            l.forEach(integer -> {
                System.out.print(" "+integer);
            });
            System.out.println("\n");
        }

    }

}
