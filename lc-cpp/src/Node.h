#pragma once
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

class Node
{
public:
    int val;
    Node *left;
    Node *right;
    Node *next;

    Node() : val(0), left(nullptr), right(nullptr), next(nullptr) {}

    Node(int _val) : val(_val), left(nullptr), right(nullptr), next(nullptr) {}

    Node(int _val, Node *_left, Node *_right, Node *_next)
        : val(_val), left(_left), right(_right), next(_next) {}

    static Node *init(vector<int> &inVec)
    {
        queue<Node *> nodeQueue;
        if (inVec.empty())
        {
            return nullptr;
        }
        Node *root = new Node(inVec[0]);
        nodeQueue.push(root);
        int lack = 0;
        int nodePos = -1;
        while (!nodeQueue.empty())
        {
            nodePos++;
            Node *node = nodeQueue.front();
            nodeQueue.pop();
            if (node == nullptr)
            {
                lack += 2;
                continue;
            }

            int left = nodePos * 2 + 1 - lack;
            int right = nodePos * 2 + 2 - lack;

            if (left < inVec.size() && inVec[left] != 0)
            {
                node->left = new Node(inVec[left]);
                nodeQueue.push(node->left);
            }
            else
            {
                nodeQueue.push(nullptr);
            }
            if (right < inVec.size() && inVec[right] != 0)
            {
                node->right = new Node(inVec[right]);
                nodeQueue.push(node->right);
            }
            else
            {
                nodeQueue.push(nullptr);
            }
        }
        return root;
    }
    static void display(Node *root)
    {
        if (root == nullptr)
        {
            cout << "tree is null" << endl;
            return;
        }
        queue<Node *> nodeQueue;
        nodeQueue.push(root);
        nodeQueue.push(nullptr);
        while (!nodeQueue.empty())
        {
            Node *node = nodeQueue.front();
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
            cout << node->val << "[->" << (node->next == nullptr ? 0 : node->next->val) << "] ";
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