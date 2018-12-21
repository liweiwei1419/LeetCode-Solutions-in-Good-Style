# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    # 【不推荐】这种方法，如果链表很长，转换成数字的时候，会越界

    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        ans = 0
        unit = 1
        while l1 or l2:
            if l1:
                ans += l1.val * unit
                l1 = l1.next
            if l2:
                ans += l2.val * unit
                l2 = l2.next
            unit *= 10
        dummy_node = ListNode(-1)
        cur = dummy_node
        for n in reversed(str(ans)):
            cur.next = ListNode(int(n))
            cur = cur.next
        return dummy_node.next
