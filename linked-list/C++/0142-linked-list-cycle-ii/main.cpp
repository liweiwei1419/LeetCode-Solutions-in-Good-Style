#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        if (head == NULL || head->next == NULL) {
            return NULL;
        }

        ListNode *dummyHead = new ListNode(-1);
        dummyHead->next = head;

        ListNode *slow = head;
        ListNode *fast = head;

        while (fast->next != NULL && fast->next->next != NULL) {
            fast = fast->next->next;
            slow = slow->next;

            if (fast == slow) {
                break;
            }
        }

        if (fast->next == NULL || fast->next->next == NULL) {
            return NULL;
        }

        slow = head;
        while (slow != fast) {
            fast = fast->next;
            slow = slow->next;
        }

        delete dummyHead;
        return slow;
    }
};

