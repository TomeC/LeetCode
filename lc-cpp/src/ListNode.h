#include <vector>
#include <iostream>
using namespace std;
#ifndef LIST_NODE_H_
#define LIST_NODE_H_
class ListNode
{
public:
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}

    static ListNode *init(vector<int> &v)
    {
        ListNode *root = nullptr, *tail = nullptr;
        for (size_t i = 0; i < v.size(); i++)
        {
            if (root == nullptr)
            {
                root = new ListNode(v[i]);
                tail = root;
            }
            else
            {
                tail->next = new ListNode(v[i]);
                tail = tail->next;
            }
        }
        return root;
    }
    static void dispaly(ListNode *root)
    {
        while (root != nullptr)
        {
            cout << root->val << "->";
            root = root->next;
        }
        cout << "null" << endl;
    }
};

#endif