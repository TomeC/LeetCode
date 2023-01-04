// https://leetcode.cn/problems/balanced-binary-tree/submissions/
#include "TreeNode.h"
#include "Utils.h"
class Solution
{
public:
    bool isBalanced(TreeNode *root)
    {
        if (root == nullptr)
        {
            return true;
        }
        return dfsDepth(root) != -1;
    }
    int dfsDepth(TreeNode *root)
    {
        if (root->left == nullptr && root->right == nullptr)
        {
            return 1;
        }
        int hl = 0, hr = 0;
        if (root->left != nullptr)
        {
            hl = dfsDepth(root->left);
            if (hl == -1)
            {
                return -1;
            }
        }
        if (root->right != nullptr)
        {
            hr = dfsDepth(root->right);
            if (hr == -1)
            {
                return -1;
            }
        }
        if (hl - hr > 1 || hl - hr < -1)
        {
            return -1;
        }
        return hl > hr ? hl + 1 : hr + 1;
    }
};
int main(int argc, char const *argv[])
{
    Solution s;
    Utils::check(s.isBalanced(TreeNode::init(vector<int>{3, 9, 20, 0, 0, 15, 7})));
    Utils::check(!s.isBalanced(TreeNode::init(vector<int>{1, 2, 2, 3, 3, 0, 0, 4, 4})));
    return 0;
}
