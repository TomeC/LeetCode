// https://leetcode.cn/problems/number-of-1-bits/description/
#include "Utils.h"
class Solution
{
public:
    int hammingWeight(uint32_t n)
    {
        int count = 0;
        for (size_t i = 0; i < 32; i++)
        {
            if ((n >> i) & 1 == 1)
            {
                ++count;
            }
        }
        return count;
    }
};
int main(int argc, char const *argv[])
{
    Solution s;
    Utils::check(s.hammingWeight(11), 3);
    Utils::check(s.hammingWeight(16), 1);
    return 0;
}
