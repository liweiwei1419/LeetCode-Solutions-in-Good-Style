class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    # 推荐写法

    def middleNode(self, head: ListNode) -> ListNode:
        if head is None:
            return None

        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow
