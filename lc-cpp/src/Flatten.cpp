// https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/submissions/
#include "TreeNode.h"
#include <vector>
#include <stack>
using namespace std;

class Solution
{
public:
    void flatten(TreeNode *root)
    {
        stack<TreeNode *> s;
        while (root != nullptr)
        {
            if (root->left != nullptr)
            {
                if (root->right != nullptr)
                {
                    s.push(root->right);
                }
                root->right = root->left;
                root->left = nullptr;
                root = root->right;
            }
            else
            {
                if (root->right != nullptr)
                {
                    root = root->right;
                }
                else
                {
                    if (!s.empty())
                    {
                        root->right = s.top();
                        s.pop();
                        root = root->right;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
    }
};
int main(int argc, char const *argv[])
{
    Solution s;
    vector<int *> v;
    v.push_back(new int(1));
    v.push_back(new int(2));
    v.push_back(new int(5));
    v.push_back(new int(3));
    v.push_back(new int(4));
    v.push_back(nullptr);
    v.push_back(new int(6));
    TreeNode *root = TreeNode::init(v);
    s.flatten(root);
    TreeNode::show(root);
    return 0;
}
