// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
#include <vector>
#include <unordered_map>
#include "TreeNode.h"

using namespace std;

class Solution
{
public:
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder)
    {
        unordered_map<int, int> inMap;
        for (size_t i = 0; i < inorder.size(); i++)
        {
            inMap[inorder[i]] = i;
        }
        return dfsBuild(preorder, 0, preorder.size(), 0, inMap);
    }
    TreeNode *dfsBuild(vector<int> &preorder, int preLeft, int preRight, int inLeft, unordered_map<int, int> &inMap)
    {
        TreeNode *root = new TreeNode(preorder[preLeft]);
        int inRootPos = inMap[preorder[preLeft]];
        int leftLen = inRootPos - inLeft;
        if (preLeft + 1 < preLeft + leftLen + 1)
        {
            root->left = dfsBuild(preorder, preLeft + 1, preLeft + leftLen + 1, inLeft, inMap);
        }
        if (preLeft + leftLen + 1 < preRight)
        {
            root->right = dfsBuild(preorder, preLeft + leftLen + 1, preRight, inRootPos + 1, inMap);
        }
        return root;
    }
};
int main(int argc, char const *argv[])
{
    Solution s;
    vector<int> preorder = {3, 9, 20, 15, 7};
    vector<int> inorder = {9, 3, 15, 20, 7};
    TreeNode *root = s.buildTree(preorder, inorder);
    TreeNode::show(root);
    return 0;
}
