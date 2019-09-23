class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    # 递归

    def reverseList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head

        # head 的下一个结点先存起来
        temp_node = head.next

        new_head = self.reverseList(temp_node)
        temp_node.next = head
        head.next = None
        return new_head
