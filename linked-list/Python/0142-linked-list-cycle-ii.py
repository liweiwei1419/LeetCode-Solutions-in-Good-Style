class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return None

        slow = head
        fast = head
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                break

        if fast.next is None or fast.next.next is None:
            return None

        slow = head
        while slow != fast:
            slow = slow.next
            fast = fast.next
        return slow
