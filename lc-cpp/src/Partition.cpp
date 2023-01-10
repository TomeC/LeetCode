// https://leetcode.cn/problems/palindrome-partitioning/description/
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    vector<vector<string>> partition(string s)
    {
        vector<vector<bool>> dp(s.length(), vector<bool>(s.length(), false));
        for (size_t right = 0; right < s.length(); right++)
        {
            for (size_t left = 0; left <= right; left++)
            {
                if (s[left] == s[right] && (right - left < 2 || dp[left + 1][right - 1]))
                {
                    dp[left][right] = true;
                }
            }
        }
        vector<vector<string>> result;
        vector<string> subResult;
        dfsPartition(s, dp, 0, subResult, result);
        return result;
    }
    void dfsPartition(string s, vector<vector<bool>> &dp, int start, vector<string> &subResult, vector<vector<string>> &result)
    {
        if (start == s.length())
        {
            result.push_back(subResult);
            return;
        }
        for (size_t i = start; i < s.length(); i++)
        {
            if (dp[start][i])
            {
                subResult.push_back(s.substr(start, i - start + 1));
                dfsPartition(s, dp, i + 1, subResult, result);
                subResult.pop_back();
            }
        }
    }
};
int main(int argc, char const *argv[])
{
    Solution s;
    vector<vector<string>> res = s.partition("aabb");
    for (size_t i = 0; i < res.size(); i++)
    {
        cout << i << ": ";
        for (size_t j = 0; j < res[i].size(); j++)
        {
            cout << res[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}
