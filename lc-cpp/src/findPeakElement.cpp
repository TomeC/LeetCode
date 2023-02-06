// https://leetcode.cn/problems/find-peak-element/
#include <vector>
#include "Utils.h"
using namespace std;

class Solution
{
public:
    int findPeakElement(vector<int> nums)
    {
        if (nums.size() < 2 || nums[0] > nums[1])
        {
            return 0;
        }

        if (nums[nums.size() - 1] > nums[nums.size() - 2])
        {
            return nums.size() - 1;
        }
        for (size_t i = 1; i < nums.size() - 1; i++)
        {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
            {
                return i;
            }
        }
        return -1;
    }
};
int main(int argc, char const *argv[])
{
    Solution s;
    Utils::check(s.findPeakElement(vector<int>{1, 2}), 1);
    Utils::check(s.findPeakElement(vector<int>{1, 2, 3, 1}), 2);
    Utils::check(s.findPeakElement(vector<int>{1, 2, 1, 3, 5, 6, 4}), 1);
    return 0;
}
