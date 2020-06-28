class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    def reverseList(self, head: ListNode) -> ListNode:
        pre_node = None
        cur_node = head
        while cur_node is not None:
            next_node = cur_node.next
            cur_node.next = pre_node
            pre_node = cur_node
            cur_node = next_node
        return pre_node
