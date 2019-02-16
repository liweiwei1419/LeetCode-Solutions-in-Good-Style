# 23. 合并K个排序链表
# 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


# 思路：分治法与优先队列


class Solution:
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """

        size = len(lists)
        if size == 0:
            return None
        return self.__merge_k_lists(lists, 0, size - 1)

    def __merge_k_lists(self, lists, left, right):
        if left >= right:
            return lists[left]
        mid = left + (right - left) // 2
        listnode1 = self.__merge_k_lists(lists, left, mid)
        listnode2 = self.__merge_k_lists(lists, mid + 1, right)
        return self.__merge_two_sorted_list_node(listnode1, listnode2)

    def __merge_two_sorted_list_node(self, list1, list2):
        if list1 is None:
            return list2
        if list2 is None:
            return list1

        if list1.val < list2.val:
            list1.next = self.__merge_two_sorted_list_node(list1.next, list2)
            return list1
        else:
            list2.next = self.__merge_two_sorted_list_node(list1, list2.next)
            return list2
