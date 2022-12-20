// https://leetcode.cn/problems/linked-list-cycle-ii/submissions/
#include "ListNode.h"
#include "Utils.h"
#include <vector>
using namespace std;

class Solution
{
public:
    static ListNode *detectCycle(ListNode *head)
    {
        ListNode *slow = head, *fast = head;
        while (true)
        {
            if (fast == nullptr || fast->next == nullptr || fast->next->next == nullptr)
            {
                return nullptr;
            }
            slow = slow->next;
            fast = fast->next->next;
            if (slow == fast)
            {
                break;
            }
        }
        slow = head;
        while (slow != fast)
        {
            slow = slow->next;
            fast = fast->next;
        }
        return slow;
    }
};

int main(int argc, char const *argv[])
{
    int a[] = {1, 2, 3};
    ListNode *l = ListNode::init(*new vector<int>(a, a + sizeof(a) / sizeof(int)));
    Utils::check(Solution::detectCycle(l), nullptr);
    l->next->next = l->next;
    Utils::check(Solution::detectCycle(l)->val, 2);

    l->next->next = l;
    Utils::check(Solution::detectCycle(l)->val, 1);
    return 0;
}
