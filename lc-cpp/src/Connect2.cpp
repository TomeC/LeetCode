// https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/

#include "Node.h"

class Solution
{
public:
    static Node *connect2(Node *root)
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

    static Node *connect(Node *root)
    {
        if (root == nullptr)
        {
            return nullptr;
        }
        if (root->left != nullptr)
        {
            if (root->right != nullptr)
            {
                root->left->next = root->right;
            }
            else
            {
                Node *tmp = root->next;
                while (tmp != nullptr && tmp->left == nullptr && tmp->right == nullptr)
                {
                    tmp = tmp->next;
                }
                root->left->next = tmp ? (tmp->left ? tmp->left : tmp->right) : nullptr;
            }
        }
        if (root->next != nullptr && root->right != nullptr)
        {
            Node *tmp = root->next;
            while (tmp != nullptr && tmp->left == nullptr && tmp->right == nullptr)
            {
                tmp = tmp->next;
            }
            root->right->next = tmp ? (tmp->left ? tmp->left : tmp->right) : nullptr;
        }
        if (root->left != nullptr)
        {
            connect(root->left);
        }

        if (root->right != nullptr)
        {
            connect(root->right);
        }

        return root;
    }
};

int main(int argc, char const *argv[])
{
    vector<int> in{1,
                   2, 3,
                   4, 5, 0, 6,
                   7, 0, 0, 0, 0, 8};
    Node *root = Node::init(in);
    Solution::connect(root);
    Node::display(root);

    vector<int> in2{2,
                    1, 3,
                    99, 7, 9, 1,
                    2, 0, 1, 99, 0, 0, 8, 8,
                    0, 0, 0, 0, 7};
    Node *root2 = Node::init(in2);
    Solution::connect2(root2);
    Node::display(root2);
    return 0;
}
