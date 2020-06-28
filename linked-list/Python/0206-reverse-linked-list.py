class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    def reverseList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head

        # head 的下一个结点先存起来
        next_node = head.next

        new_head = self.reverseList(next_node)
        next_node.next = head
        head.next = None
        return new_head
