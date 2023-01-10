package com.wkr.ge116;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @date: 2023/1/5 20:18
 * @author: wangkun
 */
public class C131Partition {
    public static void main(String[] args) {
        C131Partition partition = new C131Partition();
        System.out.println(partition.partition2("aabb"));
    }

    public List<List<String>> partition2(String s) {
        boolean dp[] = new boolean[(s.length()*(s.length()+1))/2];
        for (int right = 0; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                int pos = (s.length()+s.length()-left+1)*left/2+(right-left);
                int posPre = (s.length()+s.length()-left-1+1)*(left+1)/2+(right-1-left-1);
                if ((s.charAt(right) == s.charAt(left)) &&(right-left <= 2 || dp[posPre])) {
                    dp[pos] = true;
                } else {
                    dp[pos] = false;
                }
            }
        }

        List<List<String>> result = new LinkedList<>();
        dfsPartition2(s, 0, dp, new Stack<>(), result);
        return result;
    }
    public void dfsPartition2(String s, int start, boolean dp[], Stack<String> subList, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new LinkedList<>(subList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            int pos = (s.length()+s.length()-start+1)*start/2+(i-start);
            if (dp[pos]) {
                subList.add(s.substring(start, i+1));
                dfsPartition2(s, i+1, dp, subList, result);
                subList.pop();
            }
        }
    }

    public List<List<String>> partition(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int right = 0; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                if ((s.charAt(right) == s.charAt(left)) &&(right-left <= 2 || dp[left+1][right-1])) {
                    dp[left][right] = true;
                } else {
                    dp[left][right] = false;
                }
            }
        }

        List<List<String>> result = new LinkedList<>();
        dfsPartition(s, 0, dp, new Stack<>(), result);
        return result;
    }
    public void dfsPartition(String s, int start, boolean dp[][], Stack<String> subList, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new LinkedList<>(subList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                subList.add(s.substring(start, i+1));
                dfsPartition(s, i+1, dp, subList, result);
                subList.pop();
            }
        }
    }
}
