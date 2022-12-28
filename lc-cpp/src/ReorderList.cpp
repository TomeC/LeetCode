// https://leetcode.cn/problems/reorder-list/submissions/
#include "ListNode.h"

class Solution
{
public:
    void reorderList(ListNode *head)
    {
        if (head == nullptr || head->next == nullptr || head->next->next == nullptr)
        {
            return;
        }

        // mid pos
        ListNode *slow = head, *fast = head, *preSlow = head;
        while (true)
        {
            preSlow = slow;
            slow = slow->next;
            fast = fast->next;
            if (fast != nullptr)
            {
                fast = fast->next;
            }
            if (fast == nullptr || fast->next == nullptr)
            {
                break;
            }
        }
        preSlow->next = nullptr;
        cout << "slow pos:" << slow->val << endl;
        // reverse second half
        preSlow = slow;
        slow = slow->next;
        preSlow->next = nullptr;
        ListNode *postSlow;
        while (slow != nullptr)
        {
            postSlow = slow->next;
            slow->next = preSlow;

            preSlow = slow;
            slow = postSlow;
        }
        ListNode::dispaly(preSlow);
        // merge
        slow = preSlow;
        ListNode *postHead;
        while (head != nullptr)
        {
            postHead = head->next;
            postSlow = slow->next;

            head->next = slow;
            if (postHead != nullptr)
            {
                slow->next = postHead;
            }

            head = postHead;
            slow = postSlow;
        }
    }
};
int main(int argc, char const *argv[])
{
    Solution s;
    int l[] = {1, 2, 3};
    ListNode *head = ListNode::init(l, sizeof(l) / sizeof(int));
    s.reorderList(head);
    ListNode::dispaly(head);
    return 0;
}
