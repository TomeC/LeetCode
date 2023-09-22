package com.wkr.maxto50;

import java.util.ArrayList;
import java.util.List;
/*
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 *     "((()))", "(()())", "(())()", "()(())", "()()()"
 * */
public class C22GenerateParentheses {
	public static void main(String[] args) {
		C22GenerateParentheses s = new C22GenerateParentheses();
		System.out.println(s.generateParenthesis(5));
	}
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		List<Integer> diff = new ArrayList<>();
	 
		result.add("");
		diff.add(0);
	 
		for (int i = 0; i < 2 * n; i++) {
			List<String> tmp1 = new ArrayList<>();
			List<Integer> tmp2 = new ArrayList<>();
	 
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
