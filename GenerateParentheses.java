package com.nnk.container;

import java.util.ArrayList;
import java.util.List;
/*
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 *     "((()))", "(()())", "(())()", "()(())", "()()()"
 * */
class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		List<Integer> diff = new ArrayList<Integer>();
	 
		result.add("");
		diff.add(0);
	 
		for (int i = 0; i < 2 * n; i++) {
			List<String> tmp1 = new ArrayList<String>();
			List<Integer> tmp2 = new ArrayList<Integer>();
	 
			for (int j = 0; j < result.size(); j++) {
				String s = result.get(j);
				int k = diff.get(j);
	 
				if (i < 2*n-1) {
					tmp1.add(s+"(");
					tmp2.add(k+1);
				}
	  
				if (k > 0 && i < 2*n-1 || k == 1 && i == 2*n-1) {
					tmp1.add(s + ")");
					tmp2.add(k - 1);
				}
			}
			result = tmp1;
			diff = tmp2;
		}
		return result;
	}
}
public class Main {
   public static void main(String[] args) {
	   Solution s = new Solution();
	   System.out.println(s.generateParenthesis(5));
   }
}
