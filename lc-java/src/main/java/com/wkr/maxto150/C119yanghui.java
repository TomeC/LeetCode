package com.wkr.maxto150;

import com.wkr.common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wkr
 * @Description:
 * @date 2021/11/516:10
 */
public class C119yanghui {
    public static List<List<Integer>> resAll = new ArrayList<>();
    static {
        for (int line = 0; line < 35;line++) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < line; i++) {
                if (i == 0) {
                    res.add(1);
                    continue;
                }
                if (i == line-1) {
                    res.add(1);
                    continue;
                }
                res.add(resAll.get(line-1).get(i-1)+resAll.get(line-1).get(i));
            }
            resAll.add(res);
        }
    }
    public static void main(String[] args) {
        C119yanghui yanghui = new C119yanghui();
        Utils.check(yanghui.getRow(1), Arrays.asList(1,1), "1");
        Utils.check(yanghui.getRow(2), Arrays.asList(1,2,1), "2");
        Utils.check(yanghui.getRow(3), Arrays.asList(1,3,3,1), "3");
    }
    public List<Integer> getRow(int rowIndex) {
        return resAll.get(rowIndex+1);
    }
    public List<Integer> getRow2(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>(rowIndex+1);
        res.add(1);
        res.add(1);
        for (int line = 2; line <= rowIndex; line++) {
            for (int i = 1; i <= line; i++) {
                if (i == line) {
                    res.add(1);
                    continue;
                }
                if (i < res.size()) {
                    res.set(i, res.get(i-1)+res.get(i));
                } else {
                    res.add(res.get(i-1)+res.get(i));
                }
            }
        }
        System.out.println(res);
        return res;
    }
}
