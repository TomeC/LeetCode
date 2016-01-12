/************************************************************************/
/* 5. Longest Palindromic Substring 
*  Given a string S, find the longest palindromic substring in S. You may 
*  assume that the maximum length of S is 1000, and there exists one unique 
*  longest palindromic substring.
/************************************************************************/
#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        int len = (int)s.size();
        if (len <= 1)
        {
            return s;
        }
        string longest;

        string str;
        for (int i = 0; i < len-1; i++) {
            str = findPalindrome(s, i, i);
            if (str.size() > longest.size()){
                longest = str;
            } 
            str = findPalindrome(s, i, i+1);
            if (str.size() > longest.size()){
                longest = str;
            } 
        }

        return longest; 
    }

private:
    string findPalindrome(const string &s, int left, int right) {
        int len = (int)s.size();
        int l = left;
        int r = right;
        while (left >= 0 && right <= len-1 && s[left] == s[right]) {
            --left;
            ++right;
        }
        return s.substr(left+1, right-left-1);
    }
};

// test case
int main()
{
    string str = "abacdfgdcaba";
    Solution s;
    cout <<  str << " : " << s.longestPalindrome(str) << endl;

    str = "abbaccabba";
    cout <<  str << " : " << s.longestPalindrome(str) << endl;
    return 0;
}
