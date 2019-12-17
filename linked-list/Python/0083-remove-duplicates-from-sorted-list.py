class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    # 判断的条件是"下一个结点"

    def deleteDuplicates(self, head: ListNode) -> ListNode:
        # 先判断极端条件
        if head is None or head.next is None:
            return head
        cur = head
        while cur.next:
            next = cur.next
            if next.val == cur.val:
                # q 向后挪动一位
                cur.next = next.next
                next.next = None
            else:
                cur = cur.next
        return head
