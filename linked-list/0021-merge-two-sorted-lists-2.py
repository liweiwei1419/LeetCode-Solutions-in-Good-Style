class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    # 穿针引线

    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy_node = ListNode(-1)
        p1 = l1
        p2 = l2

        cur = dummy_node
        while p1 and p2:
            if p1.val < p2.val:
                cur.next = p1
                p1 = p1.next
            else:
                cur.next = p2
                p2 = p2.next
            cur = cur.next

        if p1 is None:
            cur.next = p2
        if p2 is None:
            cur.next = p1
        return dummy_node.next
