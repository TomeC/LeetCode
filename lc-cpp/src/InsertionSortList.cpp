// https://leetcode.cn/problems/insertion-sort-list/submissions/
#include "ListNode.h"

class Solution
{
public:
    ListNode *insertionSortList(ListNode *head)
    {
        ListNode *startNode = head, *endNode = head;
        while (endNode->next != nullptr)
        {
            ListNode *sortNode = endNode->next;

            if (sortNode->val >= endNode->val)
            {
                endNode = endNode->next;
                continue;
            }
            endNode->next = endNode->next->next;
            if (sortNode->val <= startNode->val)
            {
                sortNode->next = startNode;
                startNode = sortNode;

                continue;
            }

            ListNode *node = startNode;
            while (node != endNode)
            {
                if (sortNode->val > node->next->val)
                {
                    node = node->next;
                    continue;
                }
                else
                {
                    ListNode *p = node->next;
                    node->next = sortNode;
                    sortNode->next = p;
                    break;
                }
            }
        }
        return startNode;
    }
};

int main(int argc, char const *argv[])
{
    Solution s;
    int l1[] = {1, 2, 3, 4};
    ListNode::dispaly(s.insertionSortList(ListNode::init(l1, sizeof(l1) / sizeof(int))));

    int l2[] = {4, 3, 2, 1};
    ListNode::dispaly(s.insertionSortList(ListNode::init(l2, sizeof(l2) / sizeof(int))));

    int l3[] = {4, 5, 1, 7, 2};
    ListNode::dispaly(s.insertionSortList(ListNode::init(l3, sizeof(l3) / sizeof(int))));

    return 0;
}
