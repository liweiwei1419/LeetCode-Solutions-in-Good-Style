# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


# 穿针引线的写法

class Solution(object):
    def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
        # 比 x 小的虚拟头结点
        dummy_node_l = ListNode(-1)
        # 大于等于 x 的虚拟头结点
        dummy_node_r = ListNode(-1)
        # 用于遍历
        cur_l = dummy_node_l
        # 用于遍历
        cur_r = dummy_node_r
        while head:
            val = head.val
            if val < x:
                cur_l.next = head
                cur_l = cur_l.next
            else:
                cur_r.next = head
                cur_r = cur_r.next
            head = head.next
        cur_l.next = dummy_node_r.next
        # 特别注意：最后这一步不能忘记，否则会产生一个循环链表
        cur_r.next = None
        return dummy_node_l.next
