class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head

        p1 = head
        p2 = head.next
        new_head = self.swapPairs(p2.next)

        # 下面这两行可以交换
        p1.next = new_head
        p2.next = p1
        return p2
