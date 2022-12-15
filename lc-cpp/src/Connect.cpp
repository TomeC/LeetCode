// https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/

// Definition for a Node.
#include "Node.h"

class Solution
{
public:
    static Node *connect(Node *root)
    {
        if (root == nullptr)
        {
            return nullptr;
        }
        queue<Node *> nq;
        nq.push(root);
        nq.push(nullptr);
        while (!nq.empty())
        {
            Node *node = nq.front();
            nq.pop();
            if (node == nullptr)
            {
                if (!nq.empty())
                {
                    nq.push(nullptr);
                    continue;
                }
                break;
            }
            node->next = nq.front();
            if (node->left != nullptr)
            {
                nq.push(node->left);
            }
            if (node->right != nullptr)
            {
                nq.push(node->right);
            }
        }

        return root;
    }

    static Node *connect2(Node *root)
    {
        if (root == nullptr)
        {
            return nullptr;
        }
        if (root->left != nullptr)
        {
            root->left->next = root->right;
            if (root->next != nullptr)
            {
                root->right->next = root->next->left;
            }
                }
        if (root->left != nullptr)
        {
            connect2(root->left);
        }

        if (root->right != nullptr)
        {
            connect2(root->right);
        }

        return root;
    }
};
int main(int argc, char const *argv[])
{
    vector<int> in{1, 2, 3, 4, 5, 6, 7};
    Node *root = Node::init(in);
    Solution::connect2(root);
    Node::display(root);
    return 0;
}
