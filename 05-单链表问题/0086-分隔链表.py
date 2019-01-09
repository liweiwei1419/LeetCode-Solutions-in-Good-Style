# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):

    # 不是穿针引线，缺点：partition 的时候复制了结点

    def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """

        dummy_node_l = ListNode(-1)
        dummy_node_r = ListNode(-1)

        cur_l = dummy_node_l
        cur_r = dummy_node_r

        while head is not None:
            val = head.val

            if val < x:
                cur_l.next = ListNode(val)
                cur_l = cur_l.next
            else:
                cur_r.next = ListNode(val)
                cur_r = cur_r.next

            head = head.next
        # 把较小的链表接在较大的链表后面，这一步容易忘记
        cur_l.next = dummy_node_r.next
        return dummy_node_l.next
