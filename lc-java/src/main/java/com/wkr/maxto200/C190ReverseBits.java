package com.wkr.maxto200;

import com.wkr.common.Utils;

public class C190ReverseBits {
    public static void main(String[] args) {
        Utils.check(reverseBits(964176192), 43261596);
    }
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (n>>i&1)<<(31-i);
        }
        return res;
    }
}
