#include "ListNode.h"
#include "Utils.h"
class Solution
{
public:
    static ListNode *getIntersectionNode(ListNode *headA, ListNode *headB)
    {
        if (headA == nullptr || headB == nullptr)
        {
            return nullptr;
        }

        ListNode *na = headA, *nb = headB;
        int la = 0, lb = 0;
        while (na != nullptr)
        {
            la++;
            na = na->next;
        }
        while (nb != nullptr)
        {
            lb++;
            nb = nb->next;
        }
        while (la > lb)
        {
            headA = headA->next;
            la--;
        }
        while (lb > la)
        {
            headB = headB->next;
            lb--;
        }
        while (headA != headB)
        {
            headA = headA->next;
            headB = headB->next;
            if (headA == nullptr && headB == nullptr)
            {
                return nullptr;
            }
        }
        return headA;
    }
};
int main(int argc, char const *argv[])
{
    vector<int> v;
    v.push_back(1);
    v.push_back(2);
    ListNode *comNode = ListNode::init(v);
    v[0] = 3;
    v[1] = 4;
    ListNode *headA = ListNode::init(v);
    headA->next->next = comNode;
    v.clear();
    v.push_back(5);
    ListNode *headB = ListNode::init(v);
    headB->next = comNode;
    Utils::check(Solution::getIntersectionNode(headA, headB), comNode);
    return 0;
}
