package com.wkr.twohundred;

import com.wkr.Utils;

public class C191HammingWeight {
    public static void main(String[] args) {
        Utils.check(hammingWeight(11), 3);
        Utils.check(hammingWeight(16), 1);
    }
    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n>>i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
