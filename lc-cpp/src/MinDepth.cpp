// 111. 二叉树的最小深度
#include "TreeNode.h"
#include "Utils.h"

#include <vector>
using namespace std;

class Solution
{
public:
    int minDepth(TreeNode *root)
    {
        if (root == nullptr)
        {
            return 0;
        }
        int depth = 0;
        queue<TreeNode *> qt;
        qt.push(root);
        qt.push(nullptr);
        while (!qt.empty())
        {
            TreeNode *node = qt.front();
            qt.pop();
            if (node == nullptr)
            {
                depth++;
                if (!qt.empty())
                {
                    qt.push(nullptr);
                    continue;
                }
                break;
            }
            if (node->left == nullptr && node->right == nullptr)
            {
                depth++;
                break;
            }
            if (node->left != nullptr)
            {
                qt.push(node->left);
            }
            if (node->right != nullptr)
            {
                qt.push(node->right);
            }
        }
        return depth;
    }
};

int main(int argc, char const *argv[])
{
    Solution s;
    vector<int *> v;
    v.push_back(new int(1));
    Utils::check(s.minDepth(TreeNode::init(v)), 1);

    v.clear();
    v.push_back(new int(3));
    v.push_back(new int(9));
    v.push_back(new int(20));
    v.push_back(nullptr);
    v.push_back(nullptr);
    v.push_back(new int(15));
    v.push_back(new int(7));
    Utils::check(s.minDepth(TreeNode::init(v)), 2);

    v.clear();
    v.push_back(new int(2));
    v.push_back(nullptr);
    v.push_back(new int(3));
    v.push_back(nullptr);
    v.push_back(new int(4));
    v.push_back(nullptr);
    v.push_back(new int(5));
    v.push_back(nullptr);
    v.push_back(new int(6));
    Utils::check(s.minDepth(TreeNode::init(v)), 5);
    return 0;
}
