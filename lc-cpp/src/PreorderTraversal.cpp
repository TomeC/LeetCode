// 144. 二叉树的前序遍历
// https://leetcode.cn/problems/binary-tree-preorder-traversal/submissions/
#include "TreeNode.h"
#include "Utils.h"
#include <vector>
using namespace std;

class Solution
{
public:
    vector<int> preorderTraversal(TreeNode *root)
    {
        vector<int> res;
        if (root == nullptr)
        {
            return move(res);
        }
        preOrder(root, res);
        return move(res);
    }
    void preOrder(TreeNode *root, vector<int> &res)
    {
        if (root == nullptr)
        {
            return;
        }
        res.push_back(root->val);
        if (root->left != nullptr)
        {
            preOrder(root->left, res);
        }
        if (root->right != nullptr)
        {
            preOrder(root->right, res);
        }
    }
};

int main(int argc, char const *argv[])
{
    Solution s;
    vector<int *> v;
    v.push_back(new int(1));
    v.push_back(nullptr);
    v.push_back(new int(2));
    v.push_back(new int(3));
    s.preorderTraversal(TreeNode::init(v));
    vector<int> resVec;
    resVec.push_back(1);
    resVec.push_back(2);
    resVec.push_back(3);
    Utils::check(s.preorderTraversal(TreeNode::init(v)), resVec);

    v.clear();
    resVec.clear();
    Utils::check(s.preorderTraversal(TreeNode::init(v)), resVec);

    v.clear();
    resVec.clear();
    v.push_back(new int(1));
    resVec.push_back(1);
    Utils::check(s.preorderTraversal(TreeNode::init(v)), resVec);

    v.clear();
    resVec.clear();
    v.push_back(new int(1));
    v.push_back(new int(2));
    resVec.push_back(1);
    resVec.push_back(2);
    Utils::check(s.preorderTraversal(TreeNode::init(v)), resVec);

    v.clear();
    resVec.clear();
    v.push_back(new int(1));
    v.push_back(nullptr);
    v.push_back(new int(2));
    resVec.push_back(1);
    resVec.push_back(2);
    Utils::check(s.preorderTraversal(TreeNode::init(v)), resVec);

    return 0;
}
