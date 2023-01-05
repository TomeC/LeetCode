// https://leetcode.cn/problems/single-number-ii/submissions/
#include <vector>
#include "Utils.h"
using namespace std;

class Solution
{
public:
    int singleNumber(vector<int> nums)
    {
        int result = 0;
        for (size_t i = 0; i < 32; i++)
        {
            int sum = 0;
            for (auto num : nums)
            {
                if ((num >> i & 1) != 0)
                {
                    sum += 1;
                }
            }
            if (sum % 3 != 0)
            {
                result |= (1 << i);
            }
        }
        return result;
    }
};
int main(int argc, char const *argv[])
{
    Solution s;
    Utils::check(s.singleNumber(vector<int>{1, 3, 3, 3}), 1);
    Utils::check(s.singleNumber(vector<int>{-1, 3, 3, 3}), -1);
    Utils::check(s.singleNumber(vector<int>{1, -3, -3, -3}), 1);
    Utils::check(s.singleNumber(vector<int>{-1, -3, -3, -3}), -1);
    return 0;
}
