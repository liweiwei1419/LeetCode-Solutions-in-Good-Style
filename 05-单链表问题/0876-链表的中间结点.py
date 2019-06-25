class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# 推荐这个写法

class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        """
        :type head: ListNode
        :rtype: ListNode
        """

        if head is None:
            return None

        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow
