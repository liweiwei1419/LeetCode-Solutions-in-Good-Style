# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
# 【判断的条件是"下一个结点"】


class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        # 先判断极端条件
        if head is None or head.next is None:
            return head
        cur = head
        while cur.next:
            next = cur.next
            if next.val == cur.val:
                # q 向后挪动一位
                cur.next = next.next
                next.next = None
            else:
                cur = cur.next
        return head