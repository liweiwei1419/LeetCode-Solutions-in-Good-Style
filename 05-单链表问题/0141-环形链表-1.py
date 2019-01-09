# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):

    # 使用哈希表的方法查重肯定是可以的，但并不推荐

    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head is None:
            return False
        s = set()
        point = head
        while point:
            if point in s:
                return True
            else:
                s.add(point)
            point = point.next
        return False
