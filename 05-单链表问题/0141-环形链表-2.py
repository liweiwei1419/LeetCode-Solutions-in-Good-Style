# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):

    # 这一版代码比较费解，不推荐

    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head is None:
            return False
        slow = head
        fast = head
        # 快指针每走一步，都做了判断
        while fast:
            fast = fast.next

            if fast:
                fast = fast.next
                slow = slow.next
            else:
                return False
            if fast == slow:
                return True
        return False
