// https://leetcode.cn/problems/sort-list/submissions/
#include "ListNode.h"

class Solution
{
public:
    ListNode *sortList(ListNode *head)
    {
        if (head == nullptr || head->next == nullptr)
        {
            return head;
        }
        return subSort(head, nullptr);
    }
    ListNode *subSort(ListNode *head, ListNode *tail)
    {
        if (head == tail)
        {
            return nullptr;
        }
        if (head->next == tail)
        {
            head->next = nullptr;
            return head;
        }
        ListNode *slow = head, *fast = head;

        while (fast != tail)
        {
            slow = slow->next;
            fast = fast->next;
            if (fast != tail)
            {
                fast = fast->next;
            }
        }

        return merge(subSort(head, slow), subSort(slow, tail));
    }
    ListNode *merge(ListNode *lList, ListNode *rList)
    {
        if (lList == nullptr)
        {
            return rList;
        }
        if (rList == nullptr)
        {
            return lList;
        }
        ListNode *head = lList;
        if (lList->val > rList->val)
        {
            head = rList;
            rList = rList->next;
        }
        else
        {
            lList = lList->next;
        }
        ListNode *pt = head;
        while (lList != nullptr && rList != nullptr)
        {
            if (lList->val > rList->val)
            {
                pt->next = rList;
                pt = rList;
                rList = rList->next;
            }
            else
            {
                pt->next = lList;
                pt = lList;
                lList = lList->next;
            }
        }
        if (lList != nullptr)
        {
            pt->next = lList;
        }
        if (rList != nullptr)
        {
            pt->next = rList;
        }

        return head;
    }
};
int main(int argc, char const *argv[])
{
    Solution s;
    ListNode::dispaly(s.sortList(ListNode::init(new int[3]{1, 3, 2}, 3)));
    ListNode::dispaly(s.sortList(ListNode::init(new int[3]{1, 2, 3}, 3)));
    return 0;
}
