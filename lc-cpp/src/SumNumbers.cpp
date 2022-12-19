// https://leetcode.cn/problems/sum-root-to-leaf-numbers/submissions/
#include "TreeNode.h"
#include "Utils.h"

class Solution
{
public:
    static int sumNumbers(TreeNode *root)
    {
        if (root == nullptr)
        {
            return 0;
        }
        return calSum(root, 0);
    }
    static int calSum(TreeNode *node, int preSum)
    {
        int sum = preSum * 10 + node->val;
        if (node->left == nullptr && node->right == nullptr)
        {
            cout << sum << endl;
            return sum;
        }
        int left = node->left != nullptr ? calSum(node->left, sum) : 0;
        int right = node->right != nullptr ? calSum(node->right, sum) : 0;
        return left + right;
    }
};
int main(int argc, char const *argv[])
{
    int arr[] = {1, 2, 3};
    vector<int> v(arr, arr + sizeof(arr) / sizeof(int));
    Utils::check(Solution::sumNumbers(TreeNode::init(v)), 25);

    int arr2[] = {4, 9, 1, 5, 1};
    vector<int> v2(arr2, arr2 + sizeof(arr2) / sizeof(int));
    TreeNode::show(TreeNode::init(v2));
    Utils::check(Solution::sumNumbers(TreeNode::init(v2)), 1027);

    return 0;
}
