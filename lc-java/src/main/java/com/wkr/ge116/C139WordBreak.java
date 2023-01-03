package com.wkr.ge116;

import com.wkr.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @date: 2023/1/3 11:01
 * @author: wangkun
 */
public class C139WordBreak {
    public static void main(String[] args) {
        Utils.check(wordBreak("ltcd", Arrays.asList("lt","cd")));

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordDict);
        boolean []dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j > 0; j--) {
                if (dp[j-1] && wordSet.contains(s.substring(j-1, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
