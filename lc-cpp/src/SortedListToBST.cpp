#include "ListNode.h"
#include "TreeNode.h"

class Solution
{
public:
    TreeNode *sortedListToBST(ListNode *head)
    {
        return dfsListToBST(head, nullptr);
    }
    TreeNode *dfsListToBST(ListNode *head, ListNode *tail)
    {
        if (head == tail)
        {
            return nullptr;
        }
        if (head->next == tail)
        {
            return new TreeNode(head->val);
        }
        ListNode *slow = head, *fast = head;
        while (true)
        {
            slow = slow->next;
            fast = fast->next;
            if (fast == tail || fast->next == tail || fast->next->next == tail)
            {
                break;
            }
            fast = fast->next;
        }
        TreeNode *root = new TreeNode(slow->val);
        root->left = dfsListToBST(head, slow);
        root->right = dfsListToBST(slow->next, tail);
        return root;
    }
};
int main(int argc, char const *argv[])
{
    Solution s;
    TreeNode::show(s.sortedListToBST(ListNode::init(vector<int>{-10, -3, 0, 5, 9})));
    return 0;
}
