class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    def middleNode(self, head: ListNode) -> ListNode:
        if head is None:
            return None

        slow = head
        fast = head

        while fast:
            fast = fast.next
            if fast:
                slow = slow.next
                fast = fast.next
        return slow
