// https://leetcode.cn/problems/copy-list-with-random-pointer/submissions/
#include <iostream>
#include <unordered_map>
using namespace std;
class Node
{
public:
    int val;
    Node *next;
    Node *random;

    Node(int _val)
    {
        val = _val;
        next = nullptr;
        random = nullptr;
    }
};
class Solution
{
public:
    Node *copyRandomList(Node *head)
    {
        if (head == nullptr)
        {
            return nullptr;
        }

        Node *chead = new Node(head->val);
        Node *cnode = chead;
        unordered_map<Node *, Node *> nmap;
        nmap[head] = chead;
        Node *tnode = head->next;
        while (tnode != nullptr)
        {
            cnode->next = new Node(tnode->val);
            cnode = cnode->next;
            nmap[tnode] = cnode;
            tnode = tnode->next;
        }
        cnode = chead;
        tnode = head;
        while (tnode != nullptr)
        {
            cnode->random = nmap[tnode->random];
            tnode = tnode->next;
            cnode = cnode->next;
        }

        return chead;
    }
};
int main(int argc, char const *argv[])
{
    Node *n1 = new Node(1), *n2 = new Node(2), *n3 = new Node(3);
    n1->next = n2;
    n2->next = n3;
    n1->random = n3;
    n3->random = n1;
    Solution s;
    Node *head = s.copyRandomList(n1);
    while (head != nullptr)
    {
        if (head->random != nullptr)
        {
            cout << head->val << "[" << head->random->val << "]->";
        }
        else
        {
            cout << head->val << "[nullptr]->";
        }
        head = head->next;
    }
    cout << "nullptr" << endl;

    return 0;
}
