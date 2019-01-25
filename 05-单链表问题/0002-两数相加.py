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
        dummy_node = ListNode(-1)
        cur_node = dummy_node
        s = 0

        # 只要二者之一非空，就加下去
        while l1 or l2:
            if l1:
                s += l1.val
                # 向后挪一位
                l1 = l1.next
            if l2:
                s += l2.val
                # 向后挪一位
                l2 = l2.next
            cur_node.next = ListNode(s % 10)
            cur_node = cur_node.next
            s //= 10
        if s == 1:
            cur_node.next = ListNode(1)
        return dummy_node.next

