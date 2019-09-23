class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    # 画图

    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        dummy_node = ListNode(-1)
        dummy_node.next = head

        slow = dummy_node
        fast = head
        for i in range(n):
            fast = fast.next

        while fast:
            slow = slow.next
            fast = fast.next

        delete_node = slow.next
        slow.next = delete_node.next
        delete_node.next = None
        return dummy_node.next
