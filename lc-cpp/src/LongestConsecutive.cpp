#include <vector>
#include <unordered_set>
#include <iostream>
#include "Utils.h"
using namespace std;
class Solution
{
public:
    static int longestConsecutive(vector<int> &nums)
    {
        if (nums.size() == 0)
        {
            return 0;
        }

        unordered_set<int> num_set;
        for (int n : nums)
        {
            num_set.emplace(n);
        }
        int longest = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            int inner_longest = 1;
            int left = nums[i];
            num_set.erase(left);
            while (num_set.find(--left) != num_set.end())
            {
                num_set.erase(left);
                ++inner_longest;
            }
            // cout << nums[i] << ":" << left << "-" << inner_longest << endl;
            int right = nums[i];
            while (num_set.find(++right) != num_set.end())
            {
                num_set.erase(right);
                ++inner_longest;
            }
            // cout << nums[i] << ":" << right << "-" << inner_longest << endl;
            if (inner_longest > longest)
            {
                longest = inner_longest;
            }
            // cout << nums[i] << ":" << longest << "-" << inner_longest << endl;
        }
        return longest;
    }
};
int main(int argc, char const *argv[])
{
    int nums[] = {100, 4, 200, 1, 3, 2};

    Utils::check(Solution::longestConsecutive(*new vector<int>(nums, nums + 6)), 4);

    int nums2[] = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    Utils::check(Solution::longestConsecutive(*new vector<int>(nums2, nums2 + 10)), 9);

    Utils::check(Solution::longestConsecutive(*new vector<int>()), 0);

    int nums4[] = {9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7};
    Utils::check(Solution::longestConsecutive(*new vector<int>(nums4, nums4 + 12)), 4);

    return 0;
}
