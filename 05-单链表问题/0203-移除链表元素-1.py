# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """

        dummy_node = ListNode(-1)
        dummy_node.next = head
        cur = dummy_node

        while cur.next:
            if cur.next.val == val:
                next = cur.next
                cur.next = next.next
                next.next = None
            else:
                cur = cur.next
        return dummy_node.next
