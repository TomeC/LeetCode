// https://leetcode.cn/problems/word-break/
#include <vector>
#include <string>
#include <unordered_set>
#include <iostream>
#include <algorithm>
using namespace std;

class Solution
{
public:
    bool wordBreak(string s, vector<string> &wordDict)
    {
        unordered_set<string> wordSet;
        for_each(wordDict.begin(), wordDict.end(), [&wordSet](string &s)
                 { wordSet.emplace(s); });
        bool *dp = new bool[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++)
        {
            for (int j = i - 1; j >= 0; j--)
            {
                if (dp[j] && wordSet.find(s.substr(j, i - j)) != wordSet.end())
                {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    // v1 timeout
    bool wordBreak2(string s, vector<string> &wordDict)
    {
        unordered_set<string> sset;
        for (size_t i = 0; i < wordDict.size(); i++)
        {
            sset.insert(wordDict[i]);
        }
        bool result = false;
        dfs(s, sset, result);
        return result;
    }
    void dfs(string s, unordered_set<string> &sset, bool &result)
    {
        cout << "process: " << s << endl;
        if (result)
        {
            return;
        }

        if (s.size() == 0 || sset.find(s) != sset.end())
        {
            cout << s << " match" << endl;
            result = true;
            return;
        }
        for (size_t i = 1; i < s.size(); i++)
        {
            if (sset.find(s.substr(0, i)) != sset.end())
            {
                cout << s.substr(0, i) << ": match" << endl;
                dfs(s.substr(i, s.size() - i), sset, result);
                if (result)
                {
                    return;
                }
            }
        }
    }
};
int main(int argc, char const *argv[])
{
    Solution s;
    vector<string> vs;
    vs.emplace_back("lt");
    vs.emplace_back("l");
    vs.emplace_back("tcd");
    vs.emplace_back("cd");
    cout << s.wordBreak("ltcd", vs) << endl;
    vs.clear();
    vs.emplace_back("go");
    vs.emplace_back("goal");
    vs.emplace_back("goals");
    vs.emplace_back("special");
    cout << s.wordBreak("goalspecial", vs) << endl;
    return 0;
}
