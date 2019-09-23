class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        # 比 x 小的虚拟头结点
        dummy_node_left = ListNode(-1)
        # 大于等于 x 的虚拟头结点
        dummy_node_right = ListNode(-1)
        # 用于遍历
        cur_left = dummy_node_left
        # 用于遍历
        cur_right = dummy_node_right
        while head:
            val = head.val
            if val < x:
                cur_left.next = head
                cur_left = cur_left.next
            else:
                cur_right.next = head
                cur_right = cur_right.next
            head = head.next
        cur_left.next = dummy_node_right.next
        # 特别注意：最后这一步不能忘记，否则会产生一个循环链表
        cur_right.next = None
        return dummy_node_left.next