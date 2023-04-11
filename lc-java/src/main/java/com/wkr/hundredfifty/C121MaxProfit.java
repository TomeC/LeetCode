package com.wkr.hundredfifty;

import com.wkr.Utils;

/**
 * @author 王锟
 * @Description:
 * @date 2021/12/1322:11
 */
public class C121MaxProfit {
    public static void main(String[] args) {
        C121MaxProfit maxProfit = new C121MaxProfit();
        Utils.check(maxProfit.maxProfit(new int[]{7,1,5,3,6,4})==5, "1");
        Utils.check(maxProfit.maxProfit(new int[]{7,6,4,3,1})==0, "1");
    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) {
            return 0;
        }
        int low = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            }
            if (prices[i]-low > profit) {
                profit = prices[i]-low;
            }
        }
        return profit;
    }
}
