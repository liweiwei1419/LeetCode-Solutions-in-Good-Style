#include <iostream>

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        // 方法：穿针引线，Iterative

        // 虚拟头结点
        ListNode dummy(0);
        ListNode *cur = &dummy;
        while (l1 && l2) {
            // 只有 l1 和 l2 都非空的时候，才做穿针引线
            if (l1->val < l2->val) {
                cur->next = l1;
                l1 = l1->next;
            } else {
                cur->next = l2;
                l2 = l2->next;
            }
            cur = cur->next;
        }

        if (l1) {
            cur->next = l1;
        }

        if (l2) {
            cur->next = l2;
        }
        return dummy.next;
    }
};