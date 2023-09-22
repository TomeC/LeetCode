package com.wkr.maxto150;

import com.wkr.common.Utils;

/**
 * @Description:
 * @date: 2022/12/20 16:08
 * @author: wangkun
 */
public class C134CanCompleteCircuit {
    public static void main(String[] args) {
        //9 -1 2 -8 -1
        Utils.check(canCompleteCircuit(new int[]{11,4,7,1,0}, new int[]{2,5,5,9,1}), 0);
        Utils.check(canCompleteCircuit(new int[]{3,1,1}, new int[]{1,2,2}), 0);
        Utils.check(canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1}), 4);
        Utils.check(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}), 3);
        Utils.check(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}), -1);
        Utils.check(canCompleteCircuit(new int[]{5,8,2,8}, new int[]{6,5,6,6}), 3);

    }
    // 如果x能到达y，但是到不了y+1，那么x和y之间任意一个点也无法到达y+1
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int min = Integer.MAX_VALUE, pos = 0, tmp = 0;
        for (int i = 0; i < gas.length; i++) {
            tmp += (gas[i]-cost[i]);
            if (tmp < min) {
                min = tmp;
                pos = i;
            }
        }
        return tmp < 0 ? -1:(pos+1)%gas.length;
    }
    // 超时了
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int[] sums = new int[gas.length];
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i]-cost[i];
            sums[i] = gas[i]-cost[i];
        }
        if (total < 0) {
            return -1;
        }

        for (int i = 0; i < gas.length; i++) {
            total = 0;
            for (int j = i; j < gas.length+i; j++) {
                total += sums[j%gas.length];
                if (total <0) {
                    break;
                }
            }
            if (total >= 0) {
                return i;
            }
        }
        return -1;
    }
}
