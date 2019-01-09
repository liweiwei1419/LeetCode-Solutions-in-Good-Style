# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """

        dummy_node = ListNode(-1)
        dummy_node.next = head

        pre = dummy_node

        for _ in range(m - 1):
            pre = pre.next

        cur = pre.next
        for _ in range(n - m):
            next_temp = cur.next
            cur.next = next_temp.next
            next_temp.next = pre.next
            pre.next = next_temp

        return dummy_node.next
