package com.wkr.maxto150;

import com.wkr.common.Utils;

/**
 * @author wkr
 * @Description:
 * @date 2021/12/1512:40
 */
public class C123MaxProfit {
    public static void main(String[] args) {
        C123MaxProfit maxProfit = new C123MaxProfit();
        Utils.check(maxProfit.maxProfit(new int[]{3,3,5,0,0,3,1,4})==6, "1");
    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int p1 = 0, p2 = 0, b1 = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i-1]) {
                int res = prices[i-1]-prices[b1];
                if (res > p1) {
                    p2 = p1;
                    p1 = res;
                } else if (res > p2) {
                    p2 = res;
                }
                if (prices[b1] > prices[i]) {
                    b1 = i;
                }
                System.out.println(p1+":"+p2);
            }
            if (i == prices.length-1) {
                int res = prices[i]-prices[b1];
                p2 = p2>res?p2:res;
                System.out.println(p1+":"+p2);
            }
        }
        return p1+p2;
    }
}
