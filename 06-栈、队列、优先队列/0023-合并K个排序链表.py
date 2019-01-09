# 23. 合并K个排序链表
# 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# 思路：分治法与优先队列

class Solution:
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
