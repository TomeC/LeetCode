// https://leetcode.cn/problems/binary-tree-postorder-traversal/

#include "TreeNode.h"
#include "Utils.h"

class Solution
{
public:
    vector<int> postorderTraversal(TreeNode *root)
    {
        vector<int> res;
        if (root == nullptr)
        {
            return res;
        }
        postorder(root, res);
        return res;
    }
    void postorder(TreeNode *root, vector<int> &res)
    {
        if (root->left != nullptr)
        {
            postorder(root->left, res);
        }
        if (root->right != nullptr)
        {
            postorder(root->right, res);
        }
        res.push_back(root->val);
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
    vector<int> resVec;
    resVec.push_back(3);
    resVec.push_back(2);
    resVec.push_back(1);
    Utils::check(s.postorderTraversal(TreeNode::init(v)), resVec);

    v.clear();
    resVec.clear();
    Utils::check(s.postorderTraversal(TreeNode::init(v)), resVec);

    v.clear();
    v.push_back(new int(1));
    resVec.clear();
    resVec.push_back(1);
    Utils::check(s.postorderTraversal(TreeNode::init(v)), resVec);

    return 0;
}
