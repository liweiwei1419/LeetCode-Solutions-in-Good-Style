class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None:
            return l2

        if l2 is None:
            return l1

        dummy_node = ListNode(-1)
        cur_node = dummy_node
        s = 0

        # 只要二者之一非空，就加下去
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
