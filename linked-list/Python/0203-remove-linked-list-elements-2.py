class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    # 使用递归的方法

    def removeElements(self, head: ListNode, val: int) -> ListNode:
        # 先写递归终止条件
        if head is None:
            return head
        # 然后再写一般情况
        if head.val == val:
            return self.removeElements(head.next, val)
        else:
            head.next = self.removeElements(head.next, val)
            return head


