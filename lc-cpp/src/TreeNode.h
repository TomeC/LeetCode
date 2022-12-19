#include <vector>
#include <queue>
#include <iostream>
using namespace std;

class TreeNode
{
public:
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}

    static TreeNode *init(const vector<int> &inVec)
    {
        vector<int *> pvec;
        for (size_t i = 0; i < inVec.size(); i++)
        {
            if (inVec[i] == 0)
            {
                pvec.push_back(nullptr);
            }
            else
            {
                pvec.push_back(new int(inVec[i]));
            }
        }
        return init(pvec);
    }
    static TreeNode *init(const vector<int *> &inVec)
    {
        queue<TreeNode *> nodeQueue;
        if (inVec.empty())
        {
            return nullptr;
        }
        TreeNode *root = new TreeNode(*inVec[0]);
        nodeQueue.push(root);
        int lack = 0;
        int nodePos = -1;
        while (!nodeQueue.empty())
        {
            nodePos++;
            TreeNode *node = nodeQueue.front();
            nodeQueue.pop();
            if (node == nullptr)
            {
                lack += 2;
                continue;
            }

            int left = nodePos * 2 + 1 - lack;
            int right = nodePos * 2 + 2 - lack;

            if (left < inVec.size() && inVec[left] != nullptr)
            {
                node->left = new TreeNode(*inVec[left]);
                nodeQueue.push(node->left);
            }
            else
            {
                nodeQueue.push(nullptr);
            }
            if (right < inVec.size() && inVec[right] != nullptr)
            {
                node->right = new TreeNode(*inVec[right]);
                nodeQueue.push(node->right);
            }
            else
            {
                nodeQueue.push(nullptr);
            }
        }
        return root;
    }

    static void show(TreeNode *root)
    {
        if (root == nullptr)
        {
            cout << "tree is null" << endl;
            return;
        }
        queue<TreeNode *> nodeQueue;
        nodeQueue.push(root);
        nodeQueue.push(nullptr);
        while (!nodeQueue.empty())
        {
            TreeNode *node = nodeQueue.front();
            nodeQueue.pop();
            if (node == nullptr)
            {
                cout << endl;
                if (!nodeQueue.empty())
                {
                    nodeQueue.push(nullptr);
                    continue;
                }
                else
                {
                    break;
                }
            }
            cout << node->val << " ";
            if (node->left != nullptr)
            {
                nodeQueue.push(node->left);
            }
            if (node->right != nullptr)
            {
                nodeQueue.push(node->right);
            }
        }
        cout << "show over" << endl;
    }
};

void test()
{
    vector<int *> vec;
    vec.push_back(new int(1));
    vec.push_back(new int(2));
    vec.push_back(new int(3));
    vec.push_back(new int(4));
    TreeNode *root = TreeNode::init(vec);
    TreeNode::show(root);
    vec.clear();
    vec.push_back(new int(1));
    vec.push_back(nullptr);
    vec.push_back(new int(2));
    vec.push_back(nullptr);
    vec.push_back(new int(3));
    vec.push_back(nullptr);
    vec.push_back(new int(4));
    vec.push_back(nullptr);
    vec.push_back(new int(5));

    root = TreeNode::init(vec);
    TreeNode::show(root);
}