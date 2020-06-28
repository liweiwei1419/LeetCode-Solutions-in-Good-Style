# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if k == 0:
            return head

        if head is None:
            return head

        if head.next is None:
            return head

        # 这里 left 和 right 相当于快慢指针
        left = head
        right = head
        while right.next:
            left = right
            right = right.next

        left.next = None
        right.next = head

        head = right
        left.next = None

        newHead = self.rotateRight(head, k - 1)
        return newHead
