class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    # 穿针引线

    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        dummy_node = ListNode(-1)
        dummy_node.next = head
        cur_node = dummy_node
        for _ in range(m - 1):
            cur_node = cur_node.next
        begin = cur_node
        end = cur_node.next
        # 向前走一步
        cur_node = cur_node.next
        # 再前走一步
        pre = cur_node
        cur_node = cur_node.next
        for _ in range(n - m):
            next = cur_node.next
            cur_node.next = pre
            pre = cur_node
            cur_node = next
        begin.next = pre
        end.next = cur_node
        return dummy_node.next
