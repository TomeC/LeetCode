// /https://leetcode.cn/problems/evaluate-reverse-polish-notation/submissions/
#include <vector>
#include <stack>
#include <string>
#include <algorithm>
#include "Utils.h"
using namespace std;

class Solution
{
public:
    static int evalRPN(vector<string> &tokens)
    {
        stack<long long> s;
        for_each(tokens.begin(), tokens.end(), [&s](string &item)
                 {
                     if (item == "+")
                     {
                         int a = s.top();
                         s.pop();
                         int b = s.top();
                         s.pop();
                         s.push(a+b);
                     } else if (item == "-")
                     {
                        int a = s.top();
                         s.pop();
                         int b = s.top();
                         s.pop();
                         s.push(b-a);
                     } else if (item == "*")
                     {
                        int a = s.top();
                         s.pop();
                         int b = s.top();
                         s.pop();
                         s.push((long long)a*(long long)b);
                     } else if (item == "/")
                     {
                        int a = s.top();
                         s.pop();
                         int b = s.top();
                         s.pop();
                         s.push(b/a);
                     } else {
                        s.push(atoi(item.c_str()));
                     } });
        return s.top();
    }
};

int main(int argc, char const *argv[])
{
    string s[] = {"2", "1", "+", "3", "*"};
    vector<string> vs(s, s + sizeof(s) / sizeof(string));
    Utils::check(Solution::evalRPN(vs), 9);

    string s2[] = {"2", "1", "+", "2", "/", "2", "-", "1", "+"};
    vector<string> vs2(s2, s2 + sizeof(s2) / sizeof(string));
    Utils::check(Solution::evalRPN(vs2), 0);

    string s3[] = {"-128", "-128", "*", "-128", "*", "-128", "*", "8", "*", "-1", "*"};
    vector<string> vs3(s3, s3 + sizeof(s3) / sizeof(string));
    Utils::check(Solution::evalRPN(vs3), 0);
    return 0;
}
