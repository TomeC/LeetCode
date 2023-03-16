// https://leetcode.cn/problems/majority-element/submissions/
#include <vector>
#include <unordered_set>
#include <stdlib.h>
#include "Utils.h"
using namespace std;

class Solution
{
public:
    int majorityElement(const vector<int> &nums)
    {
        unordered_set<int> usedSet;
        int count;
        while (true)
        {
            count = 0;
            int index = rand() % nums.size();
            if (usedSet.find(index) != usedSet.end())
            {
                continue;
            }
            usedSet.insert(index);

            for (size_t i = 0; i < nums.size(); i++)
            {
                if (nums[index] == nums[i])
                {
                    count++;
                }
            }
            if (count > nums.size() / 2)
            {
                return nums[index];
            }
        }
    }
};
int main(int argc, char const *argv[])
{
    Solution s;
    Utils::check(s.majorityElement(vector<int>{1}), 1);
    Utils::check(s.majorityElement(vector<int>{3, 2, 3}), 3);
    Utils::check(s.majorityElement(vector<int>{2, 2, 1, 1, 1, 2, 2}), 2);

    return 0;
}
