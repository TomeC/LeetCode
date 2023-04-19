// https://leetcode.cn/problems/reverse-bits/description/
#include "Utils.h"

class Solution
{
public:
    uint32_t reverseBits(uint32_t n)
    {
        uint32_t res = 0;
        for (size_t i = 0; i < 32; i++)
        {
            res |= ((n >> i) & 1) << (31 - i);
        }
        return res;
    }
};

int main(int argc, char const *argv[])
{
    Solution s;
    Utils::check(s.reverseBits(43261596), 964176192);
    return 0;
}
