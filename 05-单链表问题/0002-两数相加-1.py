# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 is None:
            return l2

        if l2 is None:
            return l1

        dummy_node = ListNode(-1)
        cur_node = dummy_node
        s = 0
        while l1 or l2:
            if l1:
                s += l1.val
                l1 = l1.next
            if l2:
                s += l2.val
                l2 = l2.next
            cur_node.next = ListNode(s % 10)
            s //= 10
            cur_node = cur_node.next
        if s == 1:
            cur_node.next = ListNode(1)
        return dummy_node.next
