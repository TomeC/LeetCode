package com.wkr.maxto150;

import com.wkr.common.Utils;

/**
 * @author wkr
 * @Description:
 * @date 2021/12/1616:48
 */
public class C125isPalindrome {
    public static void main(String[] args) {
        C125isPalindrome isPalindrome = new C125isPalindrome();
        Utils.check(isPalindrome.isPalindrome("A man, a plan, a canal: Panama"), "1");
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (true) {
            char cl, cr;
            while (!isValid(s.charAt(left))) {
                left++;
            }
            while (!isValid(s.charAt(right))) {
                right--;
            }
            if (left > right) {
                break;
            }
            if (s.charAt(left) != s.charAt(right)) {
                System.out.println(left+"-"+right);
                System.out.println(s.charAt(left) +":"+ s.charAt(right));
                return false;
            }
        }
        return true;
    }
    private boolean isValid(char c) {
        return (c>='a' && c<='z')||(c>='A' && c<='Z')||c>='0' && c<='9';
    }
}
