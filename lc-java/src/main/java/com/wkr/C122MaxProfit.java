package com.wkr;

/**
 * @author 王锟
 * @Description:
 * @date 2021/12/1512:32
 */
public class C122MaxProfit {
    public static void main(String[] args) {
        C122MaxProfit maxProfit = new C122MaxProfit();
        Utils.check(maxProfit.maxProfit(new int[]{7,1,5,3,6,4})==7, "1");
        Utils.check(maxProfit.maxProfit(new int[]{1,2,3,4,5})==4, "2");
        Utils.check(maxProfit.maxProfit(new int[]{7,6,4,3,1})==0, "3");
    }
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices == null || prices.length < 2) {
            return profit;
        }
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}
